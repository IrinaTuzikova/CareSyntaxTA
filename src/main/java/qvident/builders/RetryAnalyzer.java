package qvident.builders;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;

    /* This method will be called everytime a test fails.
       It will return TRUE if a test fails and need to be retried, else it returns FALSE.
     */
    public boolean retry(ITestResult result) {

        /* You could mentioned maxRetryCount (Maximum Retry Count) as per your requirement.
        Here I took 2, If any failed test cases then it runs two times
         */
        int maxRetryCount = 1;
        if (retryCount < maxRetryCount) {
            logger.info("[AUT_INFO] Retrying " + result.getName() + " again and the count is " + (retryCount +1));
            retryCount++;
            return true;
        }
        return false;
    }

}
