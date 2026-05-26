package listeners;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestNGListener.class);

    @Override
    public void onStart(ITestContext context){
        logger.info("Test Suite Started");
        System.out.println("\nTEST SUITE EXECUTION STARTED...\n");
    }

    @Override
    public void onFinish(ITestContext context){
        logger.info("Test Suite Finished");
        System.out.println("\nTEST SUITE EXECUTION FINISHED...\n");
    }

    @Override
    public void onTestStart(ITestResult result){
        logger.info("Test Started: " + result.getName());
        System.out.println("\nTEST STARTED: " + result.getName() + "\n");;
    }

    @Override
    public void onTestSuccess(ITestResult result){
        logger.info("Test Passed: " + result.getName());
        System.out.println("\nTEST PASSED: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result){
        logger.error("Test Failed: " + result.getName());
        System.out.println("\nTEST FAILED: " + result.getName() + "\n");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        logger.warn("Test Skipped: " + result.getName());
        System.out.println("\nTEST SKIPPED: " + result.getName() + "\n");
    }
}
