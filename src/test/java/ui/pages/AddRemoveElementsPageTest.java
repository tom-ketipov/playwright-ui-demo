package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class AddRemoveElementsPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app.addRemoveElementsPage().navigate();
    }

    @Test(description = "Verifies that a user is able to navigate to the '/add_remove_elements' page.")
    public void can_navigate_to_the_add_remove_elements_page() {
        Assert.assertTrue(app.addRemoveElementsPage().getTitle().isVisible(), "Title is not visible on the Add/Remove Elements page.");
    }

    @Test(description = "Verifies that the '/add_remove_elements' page title has the correct text.")
    public void correct_text_is_set_for_the_add_remove_elements_page_title() {
        String expectedTitle = "Add/Remove Elements";
        String actualTitle = app.addRemoveElementsPage().getTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "The title text is incorrect.");
    }

    @Test(description = "Verifies that the user can add an element.")
    public void can_add_an_element_via_click_on_the_add_element_btn() {
        app.addRemoveElementsPage().clickAddBtn();
        Assert.assertTrue(app.addRemoveElementsPage().getDeleteBtn().isVisible(), "Delete button is not visible after adding an element.");
    }

    @Test(description = "Verifies that the user can add multiple elements.")
    public void can_add_multiple_elements_via_click_on_the_add_element_btn() {
        int buttonsCount = faker.number().numberBetween(2, 10);

        for (int i = 0; i < buttonsCount; i++) {
            app.addRemoveElementsPage().clickAddBtn();
        }

        int actualCount = app.addRemoveElementsPage().getDeleteBtn().count();
        Assert.assertEquals(actualCount, buttonsCount, "The number of delete buttons does not match the number of added elements.");
    }

    @Test(description = "Verifies that the user can delete an added element.")
    public void can_delete_an_element_via_click_on_the_delete_btn() {
        app.addRemoveElementsPage().clickAddBtn();
        Assert.assertTrue(app.addRemoveElementsPage().getDeleteBtn().isVisible(), "Delete button is not visible after adding an element.");

        app.addRemoveElementsPage().clickDeleteBtnByIndex(0);

        // Check if delete button disappears
        Assert.assertEquals(app.addRemoveElementsPage().getDeleteBtn().count(), 0, "Delete button was not removed after deletion.");
    }
}