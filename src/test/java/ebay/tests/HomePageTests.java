package ebay.tests;

import ebay.EbayTestsInit;
import ebay.entities.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static ebay.EbaySite.*;

public class HomePageTests  extends EbayTestsInit {

   public String EMAIL_FOR_LOGIN = "AUTEmail@gmail.com";
   public String PASSWORD_FOR_LOGIN = "AUT-fls";
   public String SEARCHED_ITEM = "Intel NUC";
   public String totalAmount = "";
   public String userId = "";

    @Test(groups = "func")
    @Features(@Feature( "Login"))
    @Stories(@Story("Login"))
    public void searchAndCaptureIntelNUC() {
        navigationThroughSite.goToLoginPageFromHomePage();
        User userForLogin = new User(EMAIL_FOR_LOGIN, PASSWORD_FOR_LOGIN);
        loginPage.loginForm.fillLoginForm(userForLogin);
        loginPage.signInBtn.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isOpened());
        userId = homePage.userIdText.getValue();
        homePage.searchField.input(SEARCHED_ITEM);
        homePage.searchBtn.click();
        softAssert.assertTrue(searchResultPage.isOpened());
        totalAmount = searchResultPage.totalAmountOfFoundItems.getValue();
        searchResultPage.searchLowestPrice();
        System.out.println("Total number: " + totalAmount);
        System.out.println("Lowest price: " + searchResultPage.lowestPrice);
        System.out.println("User ID: " + userId);

    }


}
