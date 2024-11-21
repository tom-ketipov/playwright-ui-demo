package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class ContextPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app.contextMenuPage().navigate();
    }

    @Test
    public void javascript_alert_appears_on_right_click_over_the_hotspot_element() {
        Assert.assertTrue(app.contextMenuPage().isJSAlertPrompted());
    }

    @Test
    public void correct_message_is_present_in_the_javascript_alert_dialog() {
        String alertMessage = app.contextMenuPage().promptJSAlertAndCaptureItsMessage();
        Assert.assertEquals(alertMessage, "You selected a context menu");
    }
}
