package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FormAuthenticationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(FormAuthenticationPage.class);

    private final static String FORM_AUTHENTICATION_PAGE_ENDPOINT = "/login";

    public FormAuthenticationPage(Page page) {
        super(page);
    }

    // # page locators
    Locator title = page.locator("h2");

    Locator usernameField = page.locator("#username");
    Locator passwordField = page.locator("#password");
    Locator loginBtn = page.locator("button");
    Locator logoutBtn = page.locator("//*[@id='content']/div/a");

    Locator popUpMessage = page.locator("#flash");

    // # Navigation
    @Step("Navigate to the " + FORM_AUTHENTICATION_PAGE_ENDPOINT + " page")
    public void navigate() {
        navigate(FORM_AUTHENTICATION_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    @Step("Get page title")
    public Locator getTitle() {
        return title;
    }

    @Step("Get page title text")
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Form Methods
    @Step("Fill username")
    public void fillUsername(String username) {
        logger.info("Filling in username: {}", username);
        usernameField.fill(username);
    }

    @Step("Fill password")
    public void fillPassword(String password) {
        logger.info("Filling in password");
        passwordField.fill(password);
    }

    @Step("Click login button")
    public void clickLoginBtn() {
        logger.info("Clicking Login button");
        loginBtn.click();
    }

    @Step("Click logout button")
    public void clickLogoutBtn() {
        logger.info("Clicking Logout button");
        logoutBtn.click();
    }

    public Locator getPopUpMessage() {
        return popUpMessage;
    }

    @Step("Get pop-up message text")
    public String getPopUpMessageText() {
        logger.info("Getting popup message text");
        return popUpMessage.innerText();
    }

    public void authenticate(String username, String password) {
        logger.info("Authenticating user with username: {}", username);
        fillUsername(username);
        fillPassword(password);
        clickLoginBtn();
    }
}