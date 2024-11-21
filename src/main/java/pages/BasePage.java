package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    private final static String BASE_URL = "https://the-internet.herokuapp.com";

    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void navigate(String pageUrl) {
        String URL = BASE_URL + pageUrl;
        logger.info("Navigating to {}", URL);
        page.navigate(URL);
    }

    public String url() {
        return page.url();
    }

    // >>> waits

    public void waitForElementToBeHidden(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    public void waitForElementToBeVisible(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }


    // >>> scroll

    /**
     * Scrolls the specified element into view if it is not already visible within the viewport.
     *
     * @param locator The locator of the element to scroll into view.
     */
    public void scrollIntoViewIfNeeded(Locator locator) {
        logger.info("Attempting to scroll the element into view: {}", locator);

        try {
            locator.scrollIntoViewIfNeeded();
            logger.info("Successfully scrolled the element into view: {}", locator);
        } catch (Exception e) {
            logger.error("Failed to scroll the element into view: {}", locator, e);
        }
    }


    // >>> checkbox helpers

    /**
     * Checks if the checkbox with the specified label text is checked.
     *
     * @param labelText The label text of the checkbox to check.
     * @return true if the checkbox is checked, false otherwise.
     */
    public boolean isChecked(String labelText) {
        try {
            return page.locator("//form[@id='checkboxes']/input[following-sibling::text()[contains(., '" + labelText + "')]]").isChecked();
        } catch (Exception e) {
            logger.error("Error while checking the state of the checkbox with label '{}': {}", labelText, e.getMessage());
        }
        return false;
    }

    /**
     * Checks the checkbox with the specified label text.
     *
     * @param labelText The label text of the checkbox to check.
     */
    public void check(String labelText) {
        try {
            page.locator("//form[@id='checkboxes']/input[following-sibling::text()[contains(., '" + labelText + "')]]").check();
            logger.info("Successfully checked the checkbox with label: {}", labelText);
        } catch (Exception e) {
            logger.error("Failed to check the checkbox with label: {}. Error: {}", labelText, e.getMessage());
        }
    }

    /**
     * Unchecks the checkbox with the specified label text.
     *
     * @param labelText The label text of the checkbox to uncheck.
     */
    public void uncheck(String labelText) {
        try {
            page.locator("//form[@id='checkboxes']/input[following-sibling::text()[contains(., '" + labelText + "')]]").uncheck();
            logger.info("Successfully unchecked the checkbox with label: {}", labelText);
        } catch (Exception e) {
            logger.error("Failed to uncheck the checkbox with label: {}. Error: {}", labelText, e.getMessage());
        }
    }


    // >>> dropdown helpers

    /**
     * Selects an option from a dropdown based on the visible text.
     *
     * @param dropdown   the Locator for the dropdown element
     * @param optionText the visible text of the option to be selected
     * @throws IllegalArgumentException if the dropdownLocator is null or optionText is null or empty
     * @throws NoSuchElementException   if the specified option is not found in the dropdown
     */
    public void selectDropdownOption(Locator dropdown, String optionText) {
        logger.info("Selecting option '{}' from dropdown.", optionText);
        dropdown.selectOption(optionText);
    }

    /**
     * Retrieves the currently selected option from a static dropdown.
     *
     * @param dropdownLocator the Locator for the dropdown element
     * @return the visible text of the currently selected option
     * @throws IllegalArgumentException if the dropdownLocator is null
     */
    public String getSelectedDropdownOption(Locator dropdownLocator) {
        if (dropdownLocator == null) {
            throw new IllegalArgumentException("The dropdown locator must not be null.");
        }

        logger.info("Retrieving the selected option from the dropdown.");

        // Get the selected option
        Locator selectedOptionLocator = dropdownLocator.locator("option:checked");

        if (selectedOptionLocator.count() == 0) {
            logger.warn("No option is currently selected in the dropdown.");
            return null;
        }

        String selectedText = selectedOptionLocator.innerText();
        logger.info("Currently selected option: {}", selectedText);
        return selectedText;
    }


    // >>> drag-n-drop

    /**
     * Drags an element from the specified source locator to the target locator.
     *
     * @param source The locator of the element to be dragged.
     * @param target The locator where the element should be dropped.
     */
    public void dragAndDrop(Locator source, Locator target) {
        logger.info("Dragging element from {} to {}", source, target);
        source.dragTo(target);
        logger.info("Successfully dropped element to " + target);
    }

    /**
     * Manually drags an element from the specified source locator to the target locator
     * by simulating mouse hover and mouse down/up actions.
     *
     * @param source The locator of the element to be dragged.
     * @param target The locator where the element should be dropped.
     */
    public void dragAndDropManually(Locator source, Locator target) {
        logger.info("Manually dragging element from {} to {}", source, target);
        source.hover();
        page.mouse().down();

        target.hover();
        page.mouse().up();
        logger.info("Successfully dropped element to " + target);
    }


    // >>> keyboard

    /**
     * Simulates pressing a key on the keyboard.
     *
     * @param character the character representing the key to be pressed.
     */
    public void press(char character) {
        logger.info("Pressing key: {}", character);
        page.keyboard().press(String.valueOf(character));
    }

    // >>> triggers

    /**
     * Triggers the exit-intent modal by dispatching the 'mouseleave' event on the <html> element.
     * This simulates the user moving the mouse outside the viewport
     */
    public void triggerExitIntent() {
        logger.info("Triggering exit intent by dispatching 'mouseleave' event on the HTML element");
        page.locator("html").dispatchEvent("mouseleave");
    }

    // >>> dialog

    /**
     * Accepts a prompt dialog and provides the specified text as input.
     *
     * @param text The text to enter into the prompt dialog before accepting it.
     */
    public void acceptPromptDialog(String text) {
        logger.info("Waiting for a prompt dialog to appear...");

        page.onDialog(dialog -> {
            if (dialog.type().equals("prompt")) {
                logger.info("Prompt dialog detected. Accepting with text: {}", text);
                dialog.accept(text);
            } else {
                logger.warn("Expected prompt dialog, but found: {}", dialog.type());
            }
        });
    }

    /**
     * Accepts a confirm or alert dialog by clicking the "OK" button.
     * <p>
     * This method listens for a confirm or alert dialog and simulates clicking the "OK"
     * button to accept it. It does nothing if the dialog is not of type "confirm" or "alert".
     */
    public void acceptDialog() {
        logger.info("Waiting for a confirm or alert dialog to appear...");

        page.onDialog(dialog -> {
            if (dialog.type().equals("confirm") || dialog.type().equals("alert")) {
                logger.info("Confirm/Alert dialog detected. Accepting the dialog (clicking OK).");
                dialog.accept();
            } else {
                logger.warn("Expected confirm or alert dialog, but found: {}", dialog.type());
            }
        });
    }

    /**
     * Dismisses a confirm or prompt dialog by clicking the "Cancel" button.
     * <p>
     * This method listens for a confirm or prompt dialog and simulates clicking the "Cancel"
     * button to dismiss it. It does nothing if the dialog is not of type "confirm" or "prompt".
     */
    public void dismissDialog() {
        logger.info("Waiting for a confirm or prompt dialog to appear...");

        page.onDialog(dialog -> {
            if (dialog.type().equals("confirm") || dialog.type().equals("prompt")) {
                logger.info("Confirm/Prompt dialog detected. Dismissing the dialog (clicking Cancel).");
                dialog.dismiss();
            } else {
                logger.warn("Expected confirm or prompt dialog, but found: {}", dialog.type());
            }
        });
    }

    // >>> mouse

    /**
     * Performs a right-click (context click) on the specified locator element.
     *
     * @param locator The Locator representing the element to perform the right-click on.
     */
    public void rightClick(Locator locator) {
        logger.info("Performing right-click on element: {}", locator.toString());
        locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }
}