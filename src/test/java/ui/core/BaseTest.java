package ui.core;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import core.App;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static ThreadLocal<App> threadLocalApp = new ThreadLocal<>();
    protected static ThreadLocal<Faker> threadLocalFaker = new ThreadLocal<>();
    public static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        threadLocalApp.set(new App());
        threadLocalApp.get().startBrowser(System.getProperty("browser"));

        threadLocalFaker.set(new Faker());
        threadLocalPage.set(threadLocalApp.get().getPage());
    }

    @AfterMethod
    public void tearDown() {
        if (threadLocalApp.get() != null) {
            threadLocalApp.get().quit();
        }

        threadLocalPage.remove();
        threadLocalFaker.remove();
        threadLocalApp.remove();
    }

    public App app() {
        return threadLocalApp.get();
    }

    public Faker faker() {
        return threadLocalFaker.get();
    }

    public Page page() {
        return threadLocalPage.get();
    }
}