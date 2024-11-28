package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExitIntentPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ExitIntentPage.class);
    private static final String EXIT_INTENT_PAGE_ENDPOINT = "/exit_intent";

    public ExitIntentPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator modalTitle = page.locator(".modal-title h3");

    // # Navigation
    @Step("Navigate to the " + EXIT_INTENT_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(EXIT_INTENT_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    @Step("Get modal title text")
    public String getModalTitleText() {
        logger.info("Getting modal title text");
        return modalTitle.innerText();
    }
}