package ebay.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SummaryPage extends WebPage {

    @Css(".mbg-id")
    public Text userId;

}
