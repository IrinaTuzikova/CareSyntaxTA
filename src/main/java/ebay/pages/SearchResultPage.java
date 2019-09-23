package ebay.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.qameta.allure.Step;

public class SearchResultPage extends WebPage {

    public String TYPE_OF_SORT = "Lowest price";
    public String lowestPrice = "";

    @Css(".rsHdr") public Text totalAmountOfFoundItems;
    @Css("#gh-eb-My") public Button myEbayButton;
    @XPath("//span[.='8 GB']") public Checkbox sizeOfMemory8GB;
    @XPath("//span[.='New']") public Checkbox conditionNew;

    @JDropdown(
            root = ".sort-menu-container",
            expand = ".caret-dn",
            list = "*root*#SortMenu > li",
            value = "a")
    public Dropdown sortDropdown;

    //@Css(".sort-menu-container") public Dropdown sortDropdown;

    @XPath("//a[contains(@class, 'btn')][@title='Buy it now']") public Link buyItNowLink;
    @XPath("//*[@id='ListViewInner']/*[1]") public Link cheapestItemCell;

    @XPath("//*[@id='ListViewInner']/*[1]/ul/li[@class='lvprice prc']")
    public Text cheapestItemCellPrice;

    @Step public void searchLowestPrice() {
        buyItNowLink.click();
        sizeOfMemory8GB.check();
        conditionNew.check();
        //toDo Add waiter.
        sortDropdown.is().enabled();
        sortDropdown.select(TYPE_OF_SORT);
        lowestPrice = cheapestItemCellPrice.getValue();
    }

}
