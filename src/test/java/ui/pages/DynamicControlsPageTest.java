package ui.pages;

import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DynamicControlsPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().dynamicControlsPage().navigate();
    }

    @Test(description = "Verifies that the '/dynamic_controls' page title text is correct.")
    public void correct_title_for_the_dynamic_controls_page() {
        String actualTitle = app().dynamicControlsPage().getTitleText();
        String expectedTitle = "Dynamic Controls";

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected page title to be '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verifies that the checkbox example title text is correct.")
    public void correct_title_for_the_checkbox_example_title_page() {
        String expectedTitle = "Remove/add";
        String actualTitle = app().dynamicControlsPage().getCheckboxExampleTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected checkbox example title to be '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verifies that the input example title text is correct.")
    public void correct_title_for_the_input_example_title_page() {
        String expectedTitle = "Enable/disable";
        String actualTitle = app().dynamicControlsPage().getInputExampleTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected input example title to be '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verifies that the Remove btn removes the checkbox.")
    public void can_remove_checkbox_by_click_on_the_remove_btn() {
        app().dynamicControlsPage().clickCheckboxExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);

        Assert.assertTrue(app().dynamicControlsPage().getCheckboxExampleInput().isHidden(),
                "Expected checkbox input to be hidden, but it is still visible.");
    }

    @Test(description = "Verifies that the Remove btn removes the checkbox.")
    public void can_remove_checkbox_by_click_on_the_remove_btn_playwright_assertion() {
        app().dynamicControlsPage().clickCheckboxExampleBtn();
        assertThat(app().dynamicControlsPage().getCheckboxExampleInput()).isHidden();
    }

    @Test(description = "Verifies that the checkbox example btn text is correct when the checkbox is visible.")
    public void correct_btn_text_in_the_checkbox_example_section_when_the_checkbox_is_visible() {
        String expectedButtonText = "Remove";
        String actualButtonText = app().dynamicControlsPage().getCheckboxExampleBtnText();

        Assert.assertEquals(actualButtonText, expectedButtonText,
                String.format("Expected checkbox example button text to be '%s', but got '%s'", expectedButtonText, actualButtonText));
    }

    @Test(description = "Verifies that the checkbox example btn text is correct when the checkbox is not visible.")
    public void correct_btn_text_in_the_checkbox_example_section_when_the_checkbox_is_not_visible() {
        app().dynamicControlsPage().clickCheckboxExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);

        Assert.assertEquals(app().dynamicControlsPage().getCheckboxExampleMessageText(), "It's gone!",
                "Expected message to be 'It's gone!', but got: " + app().dynamicControlsPage().getCheckboxExampleMessageText());

        String expectedButtonText = "Add";
        String actualButtonText = app().dynamicControlsPage().getCheckboxExampleBtnText();

        Assert.assertEquals(actualButtonText, expectedButtonText,
                String.format("Expected checkbox example button text to be '%s', but got '%s'", expectedButtonText, actualButtonText));
    }

    @Test(description = "Verifies that the Add btn adds a checkbox.")
    public void can_add_checkbox_by_click_on_the_add_btn() {
        // hide the element
        app().dynamicControlsPage().clickCheckboxExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getCheckboxExampleMessageText(), "It's gone!");

        // Add the element
        app().dynamicControlsPage().clickCheckboxExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getCheckboxExampleMessageText(), "It's back!");
        Assert.assertFalse(app().dynamicControlsPage().getCheckboxExampleInput().isHidden());
    }

    @Test(description = "Verifies that the Enable btn enabled the input field.")
    public void can_enable_input_field_by_click_on_the_enable_btn() {
        app().dynamicControlsPage().clickInputExampleBtn();

        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getInputExampleMessageText(), "It's enabled!");
        Assert.assertTrue(app().dynamicControlsPage().getInputExampleField().isEnabled());
    }

    @Test(description = "Verifies that the input example btn text is correct when the input is enabled.")
    public void correct_btn_text_in_the_input_example_section_when_the_checkbox_is_visible() {
        Assert.assertEquals(app().dynamicControlsPage().getInputExampleBtnText(), "Enable");
    }

    @Test(description = "Verifies that the input example btn text is correct when the checkbox is disabled.")
    public void correct_btn_text_in_the_input_example_section_when_the_checkbox_is_not_visible() {
        // Enable the element
        app().dynamicControlsPage().clickInputExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getInputExampleMessageText(), "It's enabled!");

        Assert.assertEquals(app().dynamicControlsPage().getInputExampleBtnText(), "Disable");
    }

    @Test(description = "Verifies that the Disable btn disables the text field.")
    public void can_disable_the_text_field_by_click_on_the_disable_btn() {
        // Enable the element
        app().dynamicControlsPage().clickInputExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getInputExampleMessageText(), "It's enabled!");

        // Disable the element
        app().dynamicControlsPage().clickInputExampleBtn();
        app().dynamicControlsPage().waitForElementState(app().dynamicControlsPage().getCheckboxExampleLoader(), WaitForSelectorState.HIDDEN);
        Assert.assertEquals(app().dynamicControlsPage().getInputExampleMessageText(), "It's disabled!");
        Assert.assertTrue(app().dynamicControlsPage().getInputExampleField().isDisabled());
    }
}