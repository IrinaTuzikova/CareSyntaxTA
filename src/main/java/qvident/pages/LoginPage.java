package qvident.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import qvident.section.LoginForm;


public class LoginPage extends WebPage {

    @XPath("//form")
    public LoginForm loginForm;

}
