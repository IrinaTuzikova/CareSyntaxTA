package ebay.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SearchResultPage extends WebPage {

    public String lowestPrice = "";

    @Css(".srp-controls__count-heading span:nth-child(1)")
    public Text totalAmountOfFoundItems;

    @Css("#gh-eb-My")
    public Button myEbayButton;

    @XPath("//span[.='8 GB']")
    public Checkbox sizeOfMemory8GB;

    @XPath("//span[.='New']")
    public Checkbox conditionNew;

    @JDropdown(
            root = "#w8",
            expand = "//div/*[@class='svg-icon x-flyout-arrow-down']",
            list = "//*[contains(@class, 'srp-sort__menu')]/li",
            value = ".srp-controls--selected-value")
    public Dropdown sortDropdown;

    @XPath("//ul[@class='fake-tabs__items']/li[4]")
    public Link buyItNowLink;

    @Css("#srp-river-results-listing1 .s-item__price")
    public Text cheapestItemCellPrice;

}
