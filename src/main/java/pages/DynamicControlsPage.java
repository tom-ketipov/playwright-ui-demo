package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DynamicControlsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DynamicControlsPage.class);
    private static final String DYNAMIC_CONTROLS_ENDPOINT = "/dynamic_controls";

    public DynamicControlsPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h4:nth-child(1)");

    Locator checkboxExampleTitle = page.locator("h4:nth-child(3)");
    Locator checkboxExampleInput = page.locator("#checkbox-example input");
    Locator checkboxExampleBtn = page.locator("#checkbox-example button");
    Locator checkboxExampleLoader = page.locator("#checkbox-example #loading:nth-child(3)");
    Locator checkboxExampleMessage = page.locator("#checkbox-example #message");

    Locator inputExampleTitle = page.locator("h4:nth-child(8)");
    Locator inputExampleField = page.locator("#input-example input");
    Locator inputExampleBtn = page.locator("#input-example button");
    Locator inputExampleLoader = page.locator("#checkbox-example #loading:nth-child(4)");
    Locator inputExampleMessage = page.locator("#input-example #message");


    // # helpers
    public void navigate() {
        navigate(DYNAMIC_CONTROLS_ENDPOINT);
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public String getCheckboxExampleTitle() {
        logger.info("Getting remove/add title text");
        return checkboxExampleTitle.innerText();
    }

    public String getInputExampleTitle() {
        logger.info("Getting enable/disable title text");
        return inputExampleTitle.innerText();
    }

    public void clickCheckboxExampleBtn() {
        logger.info("Clicking Checkbox Example Button");
        checkboxExampleBtn.click();
    }

    public String getCheckboxExampleBtnText() {
        String text = checkboxExampleBtn.innerText();
        logger.info("Retrieving Checkbox Example Button text: {}", text);
        return text;
    }

    public Locator getCheckboxExampleInput() {
        return checkboxExampleInput;
    }

    public Locator getCheckboxExampleLoader() {
        return checkboxExampleLoader;
    }

    public String getCheckboxExampleMessageText() {
        return checkboxExampleMessage.innerText();
    }

    public void clickInputExampleBtn() {
        logger.info("Clicking Input Example Button");
        inputExampleBtn.click();
    }

    public String getInputExampleBtnText() {
        String text = inputExampleBtn.innerText();
        logger.info("Retrieving Input Example Button text: {}", text);
        return text;
    }

    public Locator getInputExampleField() {
        return inputExampleField;
    }

    public Locator getInputExampleLoader() {
        return inputExampleLoader;
    }

    public String getInputExampleMessageText() {
        return inputExampleMessage.innerText();
    }
}