package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class DropdownPageTest extends BaseTest {


    @BeforeMethod
    public void setup() {
        super.setup();
        app.dropdownPage().navigate();
    }

    @Test(description = "Verifies that the '/dropdown' page title is correct.")
    public void verifyCorrectTitleForDropdownPage() {
        String expectedTitle = "Dropdown List";
        String actualTitle = app.dropdownPage().getTitleText();
        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected page title '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verifies that the default dropdown option is correct.")
    public void correct_default_dropdown_option() {
        String defaultDropdownOption = "Please select an option";
        String selectedOption = app.dropdownPage().getSelectedDropdownOption(app.dropdownPage().getDropdown());
        Assert.assertEquals(selectedOption, defaultDropdownOption,
                String.format("Expected default dropdown option '%s', but got '%s'", defaultDropdownOption, selectedOption));
    }

    @Test(description = "Verifies that the user can select a dropdown option.")
    public void can_select_dropdown_option() {
        String optionLabel = "Option 1";
        app.dropdownPage().selectDropdownOption(app.dropdownPage().getDropdown(), optionLabel);
        String selectedOption = app.dropdownPage().getSelectedDropdownOption(app.dropdownPage().getDropdown());
        Assert.assertEquals(selectedOption, optionLabel,
                String.format("Expected selected dropdown option '%s', but got '%s'", optionLabel, selectedOption));
    }
}