package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeyPressesPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(KeyPressesPage.class);
    private static final String KEY_PRESSES_PAGE_ENDPOINT = "/key_presses";

    public KeyPressesPage(Page page) {
        super(page);
    }

    // # page locators
    Locator title = page.locator("h3");
    Locator result = page.locator("#result");

    // # Navigation
    @Step("Navigate to the " + KEY_PRESSES_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(KEY_PRESSES_PAGE_ENDPOINT);
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

    @Step("Get result text")
    public String getResultText() {
        logger.info("Getting result text");
        return result.innerText();
    }
}