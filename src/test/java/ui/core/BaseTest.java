package ui.core;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import core.App;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected App app;
    protected Faker faker;

    public static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser(System.getProperty("browser"));

        faker = new Faker();
        threadLocalPage.set(app.getPage());
    }

    @AfterMethod
    public void tearDown() {
        threadLocalPage.remove();
        app.quit();
    }
}
