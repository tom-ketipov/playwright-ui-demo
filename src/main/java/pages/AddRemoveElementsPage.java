package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddRemoveElementsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(AddRemoveElementsPage.class);
    private static final String ADD_REMOVE_ELEMENTS_PAGE_ENDPOINT = "/add_remove_elements/";

    public AddRemoveElementsPage(Page page) {
        super(page);
    }

    // #  page locators
    Locator title = page.getByRole(AriaRole.HEADING);
    Locator addBtn = page.locator("//button[text()='Add Element']");
    Locator deleteBtn = page.locator("#elements button");

    // # Navigation
    @Step("Navigate to the " + ADD_REMOVE_ELEMENTS_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(ADD_REMOVE_ELEMENTS_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title")
    public Locator getTitle() {
        return title;
    }

    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.textContent();
    }

    // # Add Element Button
    @Step("Click add button")
    public void clickAddBtn() {
        logger.info("Clicking Add Element button");
        addBtn.click();
    }

    // # Delete Button Methods

    /**
     * Clicks the delete button at the specified index.
     *
     * @param index The index of the delete button to click.
     */
    public void clickDeleteBtnByIndex(int index) {
        logger.info("Clicking delete button at index: {}", index);
        try {
            Locator deleteButton = deleteBtn.nth(index);
            if (deleteButton.isVisible()) {
                deleteButton.click();
                logger.info("Clicked delete button at index: {}", index);
            } else {
                logger.warn("Delete button at index {} is not visible", index);
            }
        } catch (Exception e) {
            logger.error("Error while clicking delete button at index: {}", index, e);
        }
    }

    @Step("Get delete button")
    public Locator getDeleteBtn() {
        return deleteBtn;
    }
}