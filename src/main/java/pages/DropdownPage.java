package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DropdownPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DropdownPage.class);
    private static final String DROPDOWN_ENDPOINT = "/dropdown";

    public DropdownPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator dropdown = page.locator("#dropdown");

    // # helpers
    public void navigate() {
        navigate(DROPDOWN_ENDPOINT);
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public Locator getDropdown() {
        return dropdown;
    }
}