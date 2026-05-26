package utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds DB-provided test records and exposes the current record for the running scenario.
 * The TestNG runner will call setRecords(...) before test execution. A Cucumber @Before
 * hook advances the internal counter and sets the current record for the scenario.
 */
public final class DBTestDataContext {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static List<Map<Object, Object>> records;
    private static final ThreadLocal<Map<Object, Object>> currentRecord = new ThreadLocal<>();

    private DBTestDataContext() { }

    public static void setRecords(List<Map<Object, Object>> recs) {
        records = recs;
        counter.set(0);
    }

    public static Map<Object, Object> nextRecord() {
        if (records == null || records.isEmpty()) {
            currentRecord.remove();
            return null;
        }
        int idx = counter.getAndIncrement();
        // keep within bounds if scenarios > records by cycling; change behavior if you prefer different handling
        int safeIdx = idx % records.size();
        Map<Object, Object> rec = records.get(safeIdx);
        currentRecord.set(rec);
        return rec;
    }

    public static Map<Object, Object> getCurrentRecord() {
        return currentRecord.get();
    }

    /**
     * Convenience typed getters that read from the current record using the provided key.
     * Keys are matched using String.equals on the key.toString() value, which makes it
     * tolerant to Map<Object,Object> keys produced by various DB mappers.
     */
    public static String getString(String key) {
        Map<Object, Object> rec = getCurrentRecord();
        if (rec == null) return null;
        for (Object k : rec.keySet()) {
            if (key.equals(String.valueOf(k))) {
                Object v = rec.get(k);
                return v == null ? null : String.valueOf(v);
            }
        }
        return null;
    }

    public static Integer getInt(String key) {
        String s = getString(key);
        if (s == null) return null;
        try { return Integer.valueOf(s); } catch (NumberFormatException e) { return null; }
    }

    public static Long getLong(String key) {
        String s = getString(key);
        if (s == null) return null;
        try { return Long.valueOf(s); } catch (NumberFormatException e) { return null; }
    }

    public static Boolean getBoolean(String key) {
        String s = getString(key);
        if (s == null) return null;
        return Boolean.valueOf(s);
    }

    public static void clear() {
        currentRecord.remove();
    }
}

