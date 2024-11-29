package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class JavascriptAlertsPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().javascriptAlertsPage().navigate();
    }

    @Test
    public void correct_text_in_results_component_when_the_user_accepts_the_js_alert() {
        app().javascriptAlertsPage().acceptDialog();
        app().javascriptAlertsPage().clickJsAlertButton();

        Assert.assertEquals(app().javascriptAlertsPage().getResultText(), "You successfully clicked an alert");
    }

    @Test
    public void correct_text_in_results_component_when_the_user_accepts_the_js_confirm_alert() {
        app().javascriptAlertsPage().acceptDialog();
        app().javascriptAlertsPage().clickJsConfirmButton();

        Assert.assertEquals(app().javascriptAlertsPage().getResultText(), "You clicked: Ok");
    }

    @Test
    public void correct_text_in_results_component_when_the_user_dismisses_the_js_confirm_alert() {
        app().javascriptAlertsPage().dismissDialog();
        app().javascriptAlertsPage().clickJsConfirmButton();

        Assert.assertEquals(app().javascriptAlertsPage().getResultText(), "You clicked: Cancel");
    }

    @Test
    public void correct_text_in_results_component_when_the_user_accepts_the_js_prompt_alert() {
        app().javascriptAlertsPage().acceptPromptDialog("QA");
        app().javascriptAlertsPage().clickJsPromptButton();

        Assert.assertEquals(app().javascriptAlertsPage().getResultText(), "You entered: QA");
    }
}