package qvident.section;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class LoginForm extends Section {

    @Css("")
    public TextField userNameField;


    @Css("")
    public TextField passwordField;

    @Css("")
    public Button signInButton;
}
