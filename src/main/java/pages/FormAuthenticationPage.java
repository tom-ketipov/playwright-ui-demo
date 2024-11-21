package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FormAuthenticationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(FormAuthenticationPage.class);

    private final static String FORM_AUTHENTICATION_URL = "/login";

    public FormAuthenticationPage(Page page) {
        super(page);
    }

    public void navigate() {
        logger.info("Navigating to Form Authentication page");
        navigate(FORM_AUTHENTICATION_URL);
    }

    // # page locators
    Locator title = page.locator("h2");

    Locator usernameField = page.locator("#username");
    Locator passwordField = page.locator("#password");
    Locator loginBtn = page.locator("button");
    Locator logoutBtn = page.locator("//*[@id='content']/div/a");

    Locator popUpMessage = page.locator("#flash");


    // # element helpers
    public void fillUsername(String username) {
        logger.info("Filling in username: {}", username);
        usernameField.fill(username);
    }

    public void fillPassword(String password) {
        logger.info("Filling in password");
        passwordField.fill(password);
    }

    public void clickLoginBtn() {
        logger.info("Clicking Login button");
        loginBtn.click();
    }

    public void clickLogoutBtn() {
        logger.info("Clicking Logout button");
        logoutBtn.click();
    }

    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    public Locator getPopUpMessage() {
        return popUpMessage;
    }

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