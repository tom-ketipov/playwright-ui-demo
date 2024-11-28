package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DropdownPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DropdownPage.class);
    private static final String DROPDOWN_PAGE_ENDPOINT = "/dropdown";

    public DropdownPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator dropdown = page.locator("#dropdown");

    // # Navigation
    @Step("Navigate to the " + DROPDOWN_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(DROPDOWN_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Dropdown Methods
    @Step("Get dropdown")
    public Locator getDropdown() {
        return dropdown;
    }
}