package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
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
    public void navigate() {
        navigate(CHECKBOXES_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }
}