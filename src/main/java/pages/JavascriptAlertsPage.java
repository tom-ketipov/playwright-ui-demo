package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavascriptAlertsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(JavascriptAlertsPage.class);
    private static final String JAVASCRIPT_ALERTS_PAGE_ENDPOINT = "/javascript_alerts";

    public JavascriptAlertsPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator jsAlertButton = page.locator("//button[text()='Click for JS Alert']");
    Locator jsConfirmButton = page.locator("//button[text()='Click for JS Confirm']");
    Locator jsPromptButton = page.locator("//button[text()='Click for JS Prompt']");
    Locator result = page.locator("#result");

    // # Navigation
    public void navigate() {
        navigate(JAVASCRIPT_ALERTS_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # JS Alerts Methods
    public void clickJsAlertButton() {
        jsAlertButton.click();
    }

    public void clickJsConfirmButton() {
        jsConfirmButton.click();
    }

    public void clickJsPromptButton() {
        jsPromptButton.click();
    }

    public String getResultText() {
        return result.innerText();
    }
}
