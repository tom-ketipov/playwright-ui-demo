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

    @Test(description = "Verifies that the '/dropdown' page title text is correct.")
    public void correct_title_for_the_dropdown_page() {
        Assert.assertEquals(app.dropdownPage().getTitleText(), "Dropdown List");
    }

    @Test(description = "Verifies that the default dropdown option is correct.")
    public void correct_default_dropdown_option() {
        String dropdownOptionLabel = "Please select an option";

        Assert.assertEquals(app.dropdownPage().getSelectedDropdownOption(app.dropdownPage().getDropdown()), dropdownOptionLabel);
    }

    @Test(description = "Verifies that the user can select a dropdown option.")
    public void can_select_dropdown_option() {
        String dropdownOptionLabel = "Option 1";

        app.dropdownPage().selectDropdownOption(app.dropdownPage().getDropdown(), dropdownOptionLabel);
        Assert.assertEquals(app.dropdownPage().getSelectedDropdownOption(app.dropdownPage().getDropdown()), dropdownOptionLabel);
    }
}