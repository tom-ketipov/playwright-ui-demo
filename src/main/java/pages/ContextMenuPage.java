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

    // # helpers
    public void navigate() {
        navigate(CONTEXT_MENU_PAGE_ENDPOINT);
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public String promptJSAlertAndCaptureItsMessage() {
        final String[] alertMessage = new String[1];

        page.onDialog(dialog -> {
            alertMessage[0] = dialog.message();
            logger.info("Alert triggered with message: {}", alertMessage[0]);
            dialog.accept();
        });
        rightClick(hotSpot);

        return alertMessage[0];
    }

    public boolean isJSAlertPrompted() {
        AtomicBoolean isPrompted = new AtomicBoolean();

        page.onDialog(dialog -> {
            logger.info("Alert triggered");
            isPrompted.set(true);
            dialog.accept();
        });
        rightClick(hotSpot);

        return isPrompted.get();
    }
}