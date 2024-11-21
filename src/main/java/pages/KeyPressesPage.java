package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeyPressesPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(KeyPressesPage.class);
    private static final String KEY_PRESSES_ENDPOINT = "/key_presses";

    public KeyPressesPage(Page page) {
        super(page);
    }

    // # page locators
    Locator title = page.locator("h3");
    Locator result = page.locator("#result");

    // # helpers
    public void navigate() {
        navigate(KEY_PRESSES_ENDPOINT);
    }

    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public String getResultText() {
        logger.info("Getting result text");
        return result.innerText();
    }
}