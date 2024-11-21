package ui.pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class JavascriptErrorPageTest extends BaseTest {

    @Test
    public void on_load_console_error_is_logged_upon_page_navigation() {
        Assert.assertTrue(app.javascriptErrorPage().captureConsoleErrorsAfterNavigation().get(0).contains("typeerror: cannot read properties of undefined (reading 'xyz')"));
    }

    /*
    import com.microsoft.playwright.*;

import org.testng.annotations.*;

public class UITests {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    // A method to initialize Playwright (browser) setup for all tests
    @BeforeClass
    public void globalSetup() {
        playwright = Playwright.create();
    }

    // Test-specific setup: Different setups for different tests
    @BeforeMethod
    @Parameters("testType")
    public void setupTest(@Optional("default") String testType) {
        // Logic to select setup depending on the testType parameter or group
        if (testType.equals("Login")) {
            // Setup for login-related tests
            this.browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            this.context = browser.newContext();
            this.page = context.newPage();
            // Other login-specific setup
        } else if (testType.equals("Search")) {
            // Setup for search-related tests
            this.browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            this.context = browser.newContext();
            this.page = context.newPage();
            // Other search-specific setup
        }
        // Add more conditions as necessary
    }

    // After each test: Cleanup
    @AfterMethod
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
    }

    // Global teardown: Close Playwright resources
    @AfterClass
    public void globalTearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }

    // Example test 1: Login test
    @Test(groups = "Login", parameters = "Login")
    public void testLogin() {
        page.navigate("https://example.com/login");
        // Your login test code
    }

    // Example test 2: Search test
    @Test(groups = "Search", parameters = "Search")
    public void testSearch() {
        page.navigate("https://example.com/search");
        // Your search test code
    }
}

     */
}