package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
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

    // # Navigation
    @Step("Navigate to the " + FLOATING_MENU_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(FLOATING_MENU_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Footer Methods
    @Step("Get page footer")
    public Locator getFooter() {
        return footer;
    }

    // # Menu Methods
    @Step("Get page menu")
    public Locator getMenu() {
        return menu;
    }
}