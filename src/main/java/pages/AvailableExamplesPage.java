package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AvailableExamplesPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(AvailableExamplesPage.class);

    public AvailableExamplesPage(Page page) {
        super(page);
    }

    // # page locators
    Locator addRemoveElementsLink = page.locator("//a[text()='Add/Remove Elements']");
    Locator formAuthenticationLink = page.locator("//a[text()='Form Authentication']");
    Locator checkboxesLink = page.locator("//a[text()='Checkboxes']");

    // # Navigation
    public void navigate() {
        navigate("");
    }

    // # Page Links
    public void clickAddRemoveElementsLink() {
        logger.info("Clicking Add/Remove Element link");
        addRemoveElementsLink.click();
    }

    public void clickFormAuthenticationLink() {
        logger.info("Clicking Form Authentication link");
        formAuthenticationLink.click();
    }

    public void clickCheckboxesLink() {
        logger.info("Clicking Checkboxes link");
        checkboxesLink.click();
    }
}