package ebay;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ebay.pages.*;

public class EbaySite {

    @Url("/")
    public static HomePage homePage;

    public static SearchResultPage searchResultPage;

    @Url("https://signin.ebay.co.uk") @Title("Sign in or Register | eBay")
    public static LoginPage loginPage;

    @Url("https://reg.ebay.co.uk/") @Title("Sign in or Register | eBay")
    public static CreateAccountPage createAccountPage;


    /* This is not real page - adapter for all movements with actions through site. */
    public static NavigationThroughSite navigationThroughSite;

}
