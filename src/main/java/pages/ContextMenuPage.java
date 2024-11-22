package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

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
    public void navigate() {
        navigate(CONTEXT_MENU_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Action to prompt a JS alert and capture its message
    public String getJSAlertMessage() {
        final String[] alertMessage = new String[1];

        handleAlert(message -> alertMessage[0] = message);
        rightClick(hotSpot);
        return alertMessage[0];
    }

    // # Action to check if a JS alert is prompted
    public boolean isJSAlertTriggered() {
        final boolean[] isPrompted = new boolean[1];

        handleAlert(message -> isPrompted[0] = true);
        rightClick(hotSpot);
        return isPrompted[0];
    }
}