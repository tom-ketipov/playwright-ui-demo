package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DragAndDropPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DragAndDropPage.class);
    private static final String DRAG_AND_DROP_PAGE_ENDPOINT = "/drag_and_drop";

    public DragAndDropPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator columnA = page.locator("#column-a");
    Locator columnB = page.locator("#column-b");

    // # Navigation
    @Step("Navigate to the " + DRAG_AND_DROP_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(DRAG_AND_DROP_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Drag n drop containers
    @Step("Get column 'A'")
    public Locator getColumnA() {
        return columnA;
    }

    @Step("Get column 'B'")
    public Locator getColumnB() {
        return columnB;
    }
}
