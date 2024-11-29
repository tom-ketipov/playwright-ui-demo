package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class KeyPressesPageTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        super.setup();
        app().keyPressesPage().navigate();
    }

    @Test(description = "Verifies that pressing a key logs the correct character in the result text.")
    public void correct_keyboard_character_is_logged_in_the_results_text_on_key_press() {
        char keyPressed = 'k';
        app().keyPressesPage().press(keyPressed);

        String actualResult = app().keyPressesPage().getResultText();

        Assert.assertEquals(actualResult, "You entered: " + String.valueOf(keyPressed).toUpperCase(),
                String.format("Expected result text to be '%s', but got '%s'", String.valueOf(keyPressed).toUpperCase(), actualResult));
    }
}