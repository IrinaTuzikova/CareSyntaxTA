package ebay.helpers;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class ScreenShotHelper {

    public ScreenShotHelper() {}

    @Attachment(value = "{0}", type = "image/jpeg", fileExtension = "jpeg")
    public static byte[] makeScreenshot(String name) throws IOException {
        WebDriver currentDriver = WebDriverFactory.getDriver();
        return ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BYTES);
    }

    public static void makeScreenshot(String name, String errorMessage){
        try {
            makeScreenshot(name);
        } catch (IOException e) {
            logger.info(errorMessage + e);
        }
    }
}
