package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DynamicControlsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DynamicControlsPage.class);
    private static final String DYNAMIC_CONTROLS_PAGE_ENDPOINT = "/dynamic_controls";

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


    // # Navigation
    @Step("Navigate to the " + DYNAMIC_CONTROLS_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(DYNAMIC_CONTROLS_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    @Step("Get checkpoint example title text")
    public String getCheckboxExampleTitle() {
        logger.info("Getting remove/add title text");
        return checkboxExampleTitle.innerText();
    }

    @Step("Get input example title text")
    public String getInputExampleTitle() {
        logger.info("Getting enable/disable title text");
        return inputExampleTitle.innerText();
    }

    // # Checkbox Methods
    @Step("Click checkbox example button")
    public void clickCheckboxExampleBtn() {
        logger.info("Clicking Checkbox Example Button");
        checkboxExampleBtn.click();
    }

    @Step("Get checkbox example button text")
    public String getCheckboxExampleBtnText() {
        String text = checkboxExampleBtn.innerText();
        logger.info("Retrieving Checkbox Example Button text: {}", text);
        return text;
    }

    @Step("Get checkbox example input")
    public Locator getCheckboxExampleInput() {
        return checkboxExampleInput;
    }

    @Step("Get checkbox example loader")
    public Locator getCheckboxExampleLoader() {
        return checkboxExampleLoader;
    }

    @Step("Get checkbox example message text")
    public String getCheckboxExampleMessageText() {
        return checkboxExampleMessage.innerText();
    }

    // # Input Methods
    @Step("Click input example button")
    public void clickInputExampleBtn() {
        logger.info("Clicking Input Example Button");
        inputExampleBtn.click();
    }

    @Step("Get input example button text")
    public String getInputExampleBtnText() {
        String text = inputExampleBtn.innerText();
        logger.info("Retrieving Input Example Button text: {}", text);
        return text;
    }

    @Step("Get input example field")
    public Locator getInputExampleField() {
        return inputExampleField;
    }

    @Step("Get input example loader")
    public Locator getInputExampleLoader() {
        return inputExampleLoader;
    }

    @Step("Get input example message text")
    public String getInputExampleMessageText() {
        return inputExampleMessage.innerText();
    }
}