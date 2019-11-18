package qvident.builders;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Code from this resource :: https://www.swtestacademy.com/selenium-wait-javascript-angular-ajax/
 *  Check for updates there for the new versions. */

public class JSWaiter {

    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;

    //    Get the driver
    public static void setDriver (WebDriver driver) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, 10);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    public static JavascriptExecutor getJsExecFromCurrentDriver() {
        return WebDriverFactory.getJSExecutor();
    }

    public static WebDriver getCurrentDriver() {
        return WebDriverFactory.getDriver();
    }

    public static WebDriverWait getCurrentWebDriverWait() {
        return new WebDriverWait(getCurrentDriver(), 10);
    }

    private void ajaxComplete() {
        WebDriverFactory.getJSExecutor().executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    public static void waitForJQueryLoad() {
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) getCurrentDriver())
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) getJsExecFromCurrentDriver().executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                getCurrentWebDriverWait().until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }

    private void waitUntilJSReady() {
        try {
            JavascriptExecutor jsExec = WebDriverFactory.getJSExecutor();
            ExpectedCondition<Boolean> jsLoad = driver -> jsExec
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {
                getCurrentWebDriverWait().until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitUntilJQueryReady() {
        Boolean jQueryDefined = (Boolean) getJsExecFromCurrentDriver().executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll(20);

            waitForJQueryLoad();

            poll(20);
        }
    }

    public void waitUntilAngularReady() {
        try {
            Boolean angularUnDefined = (Boolean) getJsExecFromCurrentDriver().executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) getJsExecFromCurrentDriver().executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll(20);

                    waitForAngularLoad();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitUntilAngular5Ready() {
        try {
            Object angular5Check = getJsExecFromCurrentDriver().executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
            if (angular5Check != null) {
                Boolean angularPageLoaded = (Boolean) getJsExecFromCurrentDriver().executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
                if (!angularPageLoaded) {
                    poll(20);

                    waitForAngular5Load();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngular5Load() {
        String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        angularLoads(angularReadyScript);
    }

    private void angularLoads(String angularReadyScript) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript(angularReadyScript).toString());

            boolean angularReady = Boolean.valueOf(getJsExecFromCurrentDriver().executeScript(angularReadyScript).toString());

            if (!angularReady) {
                getCurrentWebDriverWait().until(angularLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    //ToDo Replace here Angular by React
    public void waitAllRequest() {
        waitUntilJSReady();
        ajaxComplete();
        waitUntilJQueryReady();
        waitUntilAngularReady();
        waitUntilAngular5Ready();
    }

    /**
     * Method to make sure a specific element has loaded on the page
     *
     * @param by
     * @param expected
     */
    public void waitForElementAreComplete(By by, int expected) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = getCurrentDriver().findElements(by).size();
            return loadingElements >= expected;
        };
        getCurrentWebDriverWait().until(angularLoad);
    }

    /**
     * Waits for the elements animation to be completed
     * @param css
     */
    public void waitForAnimationToComplete(String css) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = getCurrentDriver().findElements(By.cssSelector(css)).size();
            return loadingElements == 0;
        };
        getCurrentWebDriverWait().until(angularLoad);
    }

    private void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

