package core;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    // pages
    private AvailableExamplesPage availableExamplesPage;
    private AddRemoveElementsPage addRemoveElementsPage;
    private FormAuthenticationPage formAuthenticationPage;
    private CheckboxesPage checkboxesPage;
    private DropdownPage dropdownPage;
    private DragAndDropPage dragAndDropPage;
    private DynamicControlsPage dynamicControlsPage;
    private HoversPage hoversPage;
    private KeyPressesPage keyPressesPage;
    private ExitIntentPage exitIntentPage;
    private FloatingMenuPage floatingMenuPage;
    private ContextMenuPage contextMenuPage;
    private JavascriptAlertsPage javascriptAlertsPage;
    private JavascriptErrorPage javascriptErrorPage;
    private NestedFramesPage nestedFramesPage;

    public AvailableExamplesPage availableExamplesPage() {
        return availableExamplesPage == null ? new AvailableExamplesPage(page) : availableExamplesPage;
    }

    public AddRemoveElementsPage addRemoveElementsPage() {
        return addRemoveElementsPage == null ? new AddRemoveElementsPage(page) : addRemoveElementsPage;
    }

    public FormAuthenticationPage formAuthenticationPage() {
        return formAuthenticationPage == null ? new FormAuthenticationPage(page) : formAuthenticationPage;
    }

    public CheckboxesPage checkboxesPage() {
        return checkboxesPage == null ? new CheckboxesPage(page) : checkboxesPage;
    }

    public DropdownPage dropdownPage() {
        return dropdownPage == null ? new DropdownPage(page) : dropdownPage;
    }

    public DragAndDropPage dragAndDropPage() {
        return dragAndDropPage == null ? new DragAndDropPage(page) : dragAndDropPage;
    }

    public DynamicControlsPage dynamicControlsPage() {
        return dynamicControlsPage == null ? new DynamicControlsPage(page) : dynamicControlsPage;
    }

    public HoversPage hoversPage() {
        return hoversPage == null ? new HoversPage(page) : hoversPage;
    }

    public KeyPressesPage keyPressesPage() {
        return keyPressesPage == null ? new KeyPressesPage(page) : keyPressesPage;
    }

    public ExitIntentPage exitIntentPage() {
        return exitIntentPage == null ? new ExitIntentPage(page) : exitIntentPage;
    }

    public FloatingMenuPage floatingMenuPage() {
        return floatingMenuPage == null ? new FloatingMenuPage(page) : floatingMenuPage;
    }

    public ContextMenuPage contextMenuPage() {
        return contextMenuPage == null ? new ContextMenuPage(page) : contextMenuPage;
    }

    public JavascriptAlertsPage javascriptAlertsPage() {
        return javascriptAlertsPage == null ? new JavascriptAlertsPage(page) : javascriptAlertsPage;
    }

    public JavascriptErrorPage javascriptErrorPage() {
        return javascriptErrorPage == null ? new JavascriptErrorPage(page) : javascriptErrorPage;
    }

    public NestedFramesPage nestedFramesPage() {
        return nestedFramesPage == null ? new NestedFramesPage(page) : nestedFramesPage;
    }


    /**
     * Initializes and starts a browser instance based on the specified type.
     *
     * @param browserTypeName the name of the browser to launch (e.g., "chrome" or "firefox").
     * @throws RuntimeException if the specified browser type is unsupported.
     */
    public void startBrowser(String browserTypeName) {
        // Check for null or empty input
        if (browserTypeName == null || browserTypeName.isEmpty()) {
            logger.error("Browser type name cannot be null or empty");
            throw new IllegalArgumentException("Browser type name cannot be null or empty");
        }

        logger.info("Starting browser: {}", browserTypeName);
        playwright = Playwright.create();

        // Set browser options
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(isHeadless());

        switch (browserTypeName.toLowerCase()) {
            case "chromium" -> {
                browserType = playwright.chromium();
                logger.info("Using Chromium");
            }
            case "firefox" -> {
                browserType = playwright.firefox();
                logger.info("Using Firefox");
            }
            default -> {
                logger.error("Unsupported browser: {}", browserTypeName);
                throw new RuntimeException("Unsupported browser: " + browserTypeName);
            }
        }

        browser = browserType.launch(launchOptions);
        context = browser.newContext();
        page = context.newPage();
        logger.info("Browser started successfully");
    }

    public Page getPage() {
        return page;
    }

    /**
     * Determines if the browser should run in headless mode.
     *
     * @return true if headless mode is enabled, false if disabled.
     * @throws IllegalArgumentException if the "headless" property is set to an invalid value.
     */
    private boolean isHeadless() {
        String isHeadless = System.getProperty("headless");

        if (isHeadless == null || isHeadless.isBlank()) {
            logger.info("Defaulting to headless mode");
            return true; // Default to headless if not set
        }

        switch (isHeadless.toLowerCase()) {
            case "on" -> {
                logger.info("Headless mode is enabled");
                return true;
            }
            case "off" -> {
                logger.info("Headless mode is disabled");
                return false;
            }
            default -> {
                logger.error("Invalid value for headless property: {}", isHeadless);
                throw new IllegalArgumentException("Invalid value for headless property: " + isHeadless + ". Expected 'on' or 'off'.");
            }
        }
    }

    /**
     * Closes all resources associated with the Playwright session.
     */
    public void quit() {
        logger.info("Closing browser and resources");
        closeResource(page);
        closeResource(context);
        closeResource(browser);
        closeResource(playwright);
        logger.info("Resources closed successfully");
    }

    /**
     * Closes the specified resource if it is not null.
     * <p>
     * This method safely attempts to close the given AutoCloseable resource
     * and logs any exceptions that may occur during the closing process.
     * </p>
     *
     * @param resource the AutoCloseable resource to close, may be null.
     */
    private void closeResource(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
                logger.info("Closed resource: {}", resource.getClass().getSimpleName());
            } catch (Exception e) {
                logger.error("Error closing resource: {}", e.getMessage());
            }
        }
    }
}