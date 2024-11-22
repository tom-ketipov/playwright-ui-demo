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

    @Test(description = "Verifies that a JavaScript alert appears on right-click over the hotspot element.")
    public void javascript_alert_appears_on_right_click_over_the_hotspot_element() {
        boolean alertPrompted = app.contextMenuPage().isJSAlertTriggered();
        Assert.assertTrue(alertPrompted, "JavaScript alert was not triggered.");
    }

    @Test(description = "Verifies that the correct message is present in the JavaScript alert dialog.")
    public void correct_message_is_present_in_the_javascript_alert_dialog() {
        String alertMessage = app.contextMenuPage().getJSAlertMessage();
        Assert.assertEquals(alertMessage, "You selected a context menu", "Alert message does not match the expected message.");
    }
}
