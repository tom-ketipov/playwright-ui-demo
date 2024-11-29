package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class AvailableExamplesPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().availableExamplesPage().navigate();
    }

    @Test(description = "Verify that the user can click on the add/remove elements link.")
    public void can_click_on_the_add_remove_elements_link() {
        app().availableExamplesPage().clickAddRemoveElementsLink();
        Assert.assertTrue(app().addRemoveElementsPage().getTitle().isVisible(), "Title of Add/Remove Elements page should be visible.");
    }

    @Test(description = "Verify that the user can click on the form authentication link.")
    public void can_click_on_the_form_authentication_link() {
        app().availableExamplesPage().clickFormAuthenticationLink();
        Assert.assertTrue(app().formAuthenticationPage().getTitle().isVisible(), "Title of Form Authentication page should be visible.");
    }

    @Test(description = "Verify that the user can click on the checkboxes link.")
    public void can_click_on_the_checkboxes_link() {
        app().availableExamplesPage().clickCheckboxesLink();
        Assert.assertTrue(app().checkboxesPage().getTitle().isVisible(), "Title of Checkboxes page should be visible.");
    }
}