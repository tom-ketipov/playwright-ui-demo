package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FloatingMenuPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(FloatingMenuPage.class);
    private static final String FLOATING_MENU_PAGE_ENDPOINT = "/floating_menu";

    public FloatingMenuPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator footer = page.locator("#page-footer");
    Locator menu = page.locator("#menu");

    // # helpers
    public void navigate() {
        navigate(FLOATING_MENU_PAGE_ENDPOINT);
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public Locator getFooter() {
        return footer;
    }

    public Locator getMenu() {
        return menu;
    }
}