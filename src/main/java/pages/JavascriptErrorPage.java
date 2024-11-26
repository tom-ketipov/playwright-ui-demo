package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class JavascriptErrorPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(JavascriptErrorPage.class);
    private static final String JAVASCRIPT_ERROR_PAGE_ENDPOINT = "/javascript_error";

    public JavascriptErrorPage(Page page) {
        super(page);
    }

    // # page locators
    Locator title = page.locator("h3");

    // # Navigation
    public void navigate() {
        navigate(JAVASCRIPT_ERROR_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Console Error Methods
    public List<String> captureConsoleErrorsAfterNavigation() {
        List<String> errorMessages = new ArrayList<>();

        page.onPageError(msg -> {
            errorMessages.add(msg.toLowerCase());
        });

        navigate();
        return errorMessages;
    }
}