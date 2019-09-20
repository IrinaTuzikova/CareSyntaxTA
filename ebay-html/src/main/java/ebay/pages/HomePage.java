package ebay.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HomePage extends WebPage {

    //ToDo Move to top right menu.
    @Css("#gh-eb-My") public Button myEbayButton;

}
