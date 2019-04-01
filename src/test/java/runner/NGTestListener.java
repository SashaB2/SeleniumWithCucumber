package runner;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//add listner to TESTNG.xml
public class NGTestListener implements ITestListener{
    private final Logger LOGGER = Logger.getLogger(NGTestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.debug("Before Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.debug("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.debug("Test Failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.debug("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.debug("Test Failure with success percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.debug("Before Test Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.debug("After Test Finished");
    }
}
