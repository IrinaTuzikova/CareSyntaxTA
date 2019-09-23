package ebay.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ebay.entities.User;
import io.qameta.allure.Step;

public class LoginForm extends Form<User> {

    @Css("#userid") public TextField emailField;
    @Css("#pass") public TextField passwordField;

    @Css("#sgnBt") public Button signInButton;

    @Step public void fillLoginForm(User user) {
        emailField.input(user.getEmail());
        passwordField.input(user.getPassword());
    }

}


