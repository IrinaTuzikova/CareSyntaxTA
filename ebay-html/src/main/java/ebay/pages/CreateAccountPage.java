package ebay.pages;


import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import ebay.sections.CreateAccountForm;

public class CreateAccountPage  extends WebPage {

    @Css("#pgWidth") public CreateAccountForm createAccountForm;

}
