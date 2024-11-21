package ui.core;

import com.github.javafaker.Faker;
import core.App;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected App app;
    protected Faker faker;

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser(System.getProperty("browser"));
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        app.quit();
    }
}