package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContextMenuPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ContextMenuPage.class);
    private static final String CONTEXT_MENU_PAGE_ENDPOINT = "/context_menu";

    public ContextMenuPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator hotSpot = page.locator("#hot-spot");

    // # Navigation
    @Step("Navigate to the " + CONTEXT_MENU_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(CONTEXT_MENU_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Action to prompt a JS alert and capture its message
    @Step("Get JS alert message")
    public String getJSAlertMessage() {
        final String[] alertMessage = new String[1];

        waitForAlert(message -> alertMessage[0] = message);
        rightClick(hotSpot);
        return alertMessage[0];
    }

    // # Action to check if a JS alert is prompted
    public boolean isJSAlertTriggered() {
        final boolean[] isPrompted = new boolean[1];

        waitForAlert(message -> isPrompted[0] = true);
        rightClick(hotSpot);
        return isPrompted[0];
    }
}