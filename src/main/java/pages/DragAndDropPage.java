package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
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


    // # helpers
    public void navigate() {
        navigate(DRAG_AND_DROP_PAGE_ENDPOINT);
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public Locator getColumnA() {
        return columnA;
    }

    public Locator getColumnB() {
        return columnB;
    }
}
