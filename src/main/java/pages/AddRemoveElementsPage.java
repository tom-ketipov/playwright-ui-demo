package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddRemoveElementsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(AddRemoveElementsPage.class);
    private static final String ADD_REMOVE_ELEMENTS_PAGE_ENDPOINT = "/add_remove_elements/";

    public AddRemoveElementsPage(Page page) {
        super(page);
    }

    public void navigate() {
        navigate(ADD_REMOVE_ELEMENTS_PAGE_ENDPOINT);
    }

    // #  page locators
    Locator title = page.getByRole(AriaRole.HEADING);
    Locator addBtn = page.locator("//button[text()='Add Element']");
    Locator deleteBtn = page.locator("#elements button");

    // # element helpers
    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.textContent();
    }

    public void clickAddBtn() {
        logger.info("Clicking Add Element button");
        addBtn.click();
    }

    public void clickDeleteBtn() {
        logger.info("Clicking delete button at index: 0");
        deleteBtn.nth(0).click();
    }

    public void clickDeleteBtnByIndex(int index) {
        logger.info("Clicking delete button at index: {}", index);
        deleteBtn.nth(index).click();
    }

    public Locator getDeleteBtn() {
        return deleteBtn;
    }
}