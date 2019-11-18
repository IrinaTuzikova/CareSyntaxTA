package qvident;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qvident.listeners.TestNGListener;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class QvidentTestsInit extends TestNGListener {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(QvidentSite.class);
        logger.toLog("***** Run Tests *****");

    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
