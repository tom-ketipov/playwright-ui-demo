package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckboxesPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(CheckboxesPage.class);
    private static final String CHECKBOXES_PAGE_ENDPOINT = "/checkboxes";

    public CheckboxesPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");

    // # Navigation
    @Step("Navigate to the " + CHECKBOXES_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(CHECKBOXES_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title")
    public Locator getTitle() {
        return title;
    }

    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }
}