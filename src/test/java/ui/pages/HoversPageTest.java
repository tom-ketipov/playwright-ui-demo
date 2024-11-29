package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class HoversPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().hoversPage().navigate();
    }

    @Test(description = "Verifies that clicking the 'View Profile' link for the user redirects to the correct profile page.")
    public void the_view_profile_link_redirects_to_the_correct_page() {
        app().hoversPage().clickFigureProfileLinkByHeaderText("user2");

        String currentUrl = app().hoversPage().url();

        Assert.assertTrue(currentUrl.contains("users/2"),
                String.format("Expected URL to contain '%s', but got '%s'", "users/2", currentUrl));
    }
}