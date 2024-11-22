package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;


public class CheckboxesPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app.checkboxesPage().navigate();
    }

    @Test(description = "Verifies that the '/checkboxes' page title has the correct text.")
    public void correct_title_for_the_checkboxes_page() {
        String expectedTitle = "Checkboxes";
        String actualTitle = app.checkboxesPage().getTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "The title text is incorrect on the Checkboxes page.");
    }

    @Test(description = "Verifies that the checkboxes can be checked.")
    public void can_check_a_checkbox() {
        String checkboxLabel = " checkbox 1";

        app.checkboxesPage().check(checkboxLabel);
        Assert.assertTrue(app.checkboxesPage().isChecked(checkboxLabel), checkboxLabel + " should be checked.");
    }

    @Test(description = "Verifies that the checkboxes can be un-checked.")
    public void can_uncheck_a_checkbox() {
        String checkboxLabel = " checkbox 1";

        app.checkboxesPage().check(checkboxLabel);
        app.checkboxesPage().uncheck(checkboxLabel);
        Assert.assertFalse(app.checkboxesPage().isChecked(checkboxLabel), checkboxLabel + " should be unchecked.");
    }
}