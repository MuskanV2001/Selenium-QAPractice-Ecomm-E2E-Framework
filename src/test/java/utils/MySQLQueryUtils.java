package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLQueryUtils {

    public static List<Map<Object, Object>> getTestData(){
        try{
            Connection conn = DBConnectionUtils.getSQLConnection();

            Statement sqlStmt = conn.createStatement();

            ResultSet rowSet = sqlStmt.executeQuery("SELECT * FROM CUSTOMERS");

            List<Map<Object, Object>> testData = new ArrayList<>();

            while(rowSet.next()){
                Map<Object, Object> rowData = new HashMap<>();
                rowData.put("FIRSTNAME", rowSet.getString("FIRSTNAME"));
                rowData.put("LASTNAME", rowSet.getString("LASTNAME"));
                rowData.put("EMAIL", rowSet.getString("EMAIL"));
                rowData.put("PASSWORD", rowSet.getString("PASSWORD"));
                rowData.put("PRODUCTS_TO_PURCHASE", rowSet.getString("PRODUCTS_TO_PURCHASE"));
                testData.add(rowData);
            }

            rowSet.close();
            sqlStmt.close();

            DBConnectionUtils.closeConnection();

            return testData;

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
