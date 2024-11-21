package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HoversPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HoversPage.class);
    private static final String HOVERS_ENDPOINT = "/hovers";

    public HoversPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");
    Locator figures = page.locator(".figure");


    // # helpers
    public void navigate() {
        navigate(HOVERS_ENDPOINT);
    }

    public Locator getTitle() {
        return title;
    }

    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    /**
     * Retrieves the Locator of a figure element based on the specified header text.
     *
     * @param headerText the text of the header (h5) to search for within the figure elements.
     * @return the Locator for the figure that contains the specified header text, or null if no match is found.
     */
    public Locator getFigureByHeaderText(String headerText) {
        logger.info("Searching for figure with header text: {}", headerText);

        for (Locator figure : figures.all()) {
            figure.hover();
            Locator figureHeader = figure.locator("h5");
            String currentHeaderText = figureHeader.innerText();

            logger.debug("Checking header text: {}", currentHeaderText);

            if (currentHeaderText.contains(headerText)) {
                logger.info("Found figure with header: {}", currentHeaderText);
                return figure;
            }
        }

        logger.warn("No figure found with header containing text: {}", headerText);
        return null;
    }

    /**
     * Clicks the profile link of a figure element identified by the specified header text.
     *
     * @param headerText the text of the header (h5) used to locate the figure whose link will be clicked.
     *                   If no figure with the specified header is found, a warning is logged.
     */
    public void clickFigureProfileLinkByHeaderText(String headerText) {
        Locator figure = getFigureByHeaderText(headerText);

        if (figure != null) {
            logger.info("Clicking the profile link for figure with header: {}", headerText);
            figure.hover();
            figure.getByRole(AriaRole.LINK).click();
        } else {
            logger.warn("No figure found with header: {}", headerText);
        }
    }
}