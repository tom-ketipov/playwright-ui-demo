package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class FloatingMenuPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().floatingMenuPage().navigate();
    }

    @Test(description = "Verifies that the floating menu is visible if the user is on the bottom of the page.")
    public void floating_menu_is_visible_when_the_user_is_on_the_bottom_of_the_page() {
        app().floatingMenuPage().scrollIntoViewIfNeeded(app().floatingMenuPage().getFooter());

        Assert.assertTrue(app().floatingMenuPage().getMenu().isVisible()
                , "Floating menu should be visible at the bottom of the page.");
    }
}
