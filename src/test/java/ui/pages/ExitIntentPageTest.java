package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class ExitIntentPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().exitIntentPage().navigate();
    }

    @Test(description = "Verifies that the '/exit_intent' page modal title text is correct.")
    public void correct_title_for_the_exit_intent_modal() {
        app().exitIntentPage().triggerExitIntent();
        Assert.assertEquals(app().exitIntentPage().getModalTitleText(), "THIS IS A MODAL WINDOW");
    }
}