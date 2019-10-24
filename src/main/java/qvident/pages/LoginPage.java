package qvident.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import ebay.sections.LoginForm;

public class LoginPage extends WebPage {

    @Css(".form-signin")
    public LoginForm loginForm;


}
