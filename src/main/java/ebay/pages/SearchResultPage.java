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

    public String TYPE_OF_SORT = "Lowest price";
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
            root = "#DashSortByContainer",
            expand = ".caret-dn",
            list = "#SortMenu>li",
            value = "a.dropdown-toggle")
    public Dropdown sortDropdown;

    @XPath("//a[contains(@class, 'btn')][@title='Buy it now']")
    public Link buyItNowLink;

    @XPath("//*[@id='ListViewInner']/*[1]")
    public Link cheapestItemCell;

    @XPath("//*[@id='ListViewInner']/*[1]/ul/li[@class='lvprice prc']")
    public Text cheapestItemCellPrice;

}
