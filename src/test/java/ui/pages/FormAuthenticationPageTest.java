package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class FormAuthenticationPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app.formAuthenticationPage().navigate();
    }

    @Test(description = "Verify that the user can authenticate with valid credentials.")
    public void can_authenticate_with_valid_credentials() {
        app.formAuthenticationPage().authenticate(System.getProperty("username"), System.getProperty("password"));

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessage().isVisible());
    }

    @Test(description = "Verify that the user can't authenticate with incorrect username.")
    public void cant_authenticate_with_incorrect_username() {
        app.formAuthenticationPage().authenticate(faker.name().username(), System.getProperty("password"));

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("Your username is invalid!"));
    }

    @Test(description = "Verify that the user can't authenticate with empty username.")
    public void cant_authenticate_with_empty_username() {
        app.formAuthenticationPage().fillPassword(System.getProperty("password"));
        app.formAuthenticationPage().clickLoginBtn();

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("Your username is invalid!"));
    }

    @Test(description = "Verify that the user can't authenticate with incorrect password.")
    public void cant_authenticate_with_incorrect_password() {
        app.formAuthenticationPage().authenticate(System.getProperty("username"), faker.internet().password());

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("Your password is invalid!"));
    }

    @Test(description = "Verify that the user can't authenticate with empty password.")
    public void cant_authenticate_with_empty_password() {
        app.formAuthenticationPage().fillUsername(System.getProperty("username"));
        app.formAuthenticationPage().clickLoginBtn();

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("Your password is invalid!"));
    }

    @Test(description = "Verify that the '/secure' page pop-up message text is correct.")
    public void correct_pop_up_message_in_the_secure_page() {
        app.formAuthenticationPage().authenticate(System.getProperty("username"), System.getProperty("password"));

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("You logged into a secure area!"));
    }

    @Test(description = "Verify that the can logout from the '/secure' page.")
    public void can_logout_from_the_secure_page() {
        app.formAuthenticationPage().authenticate(System.getProperty("username"), System.getProperty("password"));
        app.formAuthenticationPage().clickLogoutBtn();

        Assert.assertTrue(app.formAuthenticationPage().getPopUpMessageText().contains("You logged out of the secure area!"));
    }
}