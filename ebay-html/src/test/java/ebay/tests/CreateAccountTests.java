package ebay.tests;

import ebay.EbayTestsInit;
import ebay.entities.User;
import ebay.generator.UserGenerator;
import ebay.helpers.FileReadAndWriteHelper;
import ebay.sections.CreateAccountForm;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static ebay.EbaySite.createAccountPage;
import static ebay.EbaySite.navigationThroughSite;

public class CreateAccountTests extends EbayTestsInit {

    public static final String PATH = "src/test/resources";

    @Test(groups = "func")
    @Features(@Feature( "Login"))
    @Stories(@Story("Create Account"))
    public void createAccountWithValidData(){
        navigationThroughSite.goToLoginPageFromHomePage();
        navigationThroughSite.goToCreateAccountPageFromLoginPage();
        User randomGeneratedUser = UserGenerator.randomGeneratedUser;
        CreateAccountForm createAccountForm = createAccountPage.createAccountForm;
        createAccountForm.fill(randomGeneratedUser);
        createAccountForm.submit();
        String filePath = FileReadAndWriteHelper.getAbsolutePathByFileName(PATH,"AlreadyCreatedUsers");
        FileReadAndWriteHelper.writeUserDetailsToTheFileWithName(filePath,
                randomGeneratedUser.print());
    }

}
