package ebay.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HomePage extends WebPage {

    //ToDo Move to top right menu.
    @Css(".mbg-id")
    public Text userIdText;

    @Css("#gh-eb-My")
    public Button myEbayButton;

    @Css("#gh-ac")
    public TextField searchField;

    @Css("#gh-btn")
    public Button searchBtn;

}
