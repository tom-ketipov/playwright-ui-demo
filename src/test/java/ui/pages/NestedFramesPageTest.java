package ui.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class NestedFramesPageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app.nestedFramesPage().navigate();
    }

    @Test(description = "Verifies that the bottom frame text of the /nested_frames page is correct.")
    public void correct_text_for_the_bottom_frame() {
        String actualText = app.nestedFramesPage().getFrameText(app.nestedFramesPage().getBottomFrame());
        Assert.assertEquals(actualText, "BOTTOM", "The bottom frame text is not correct.");
    }

    @Test(description = "Verifies that the top-left frame text of the /nested_frames page is correct.")
    public void correct_text_for_the_top_left_frame() {
        String actualText = app.nestedFramesPage().getFrameText(app.nestedFramesPage().getLeftFrame());
        Assert.assertEquals(actualText, "LEFT", "The top-left frame text is not correct.");
    }

    @Test(description = "Verifies that the top-middle frame text of the /nested_frames page is correct.")
    public void correct_text_for_the_top_middle_frame() {
        String actualText = app.nestedFramesPage().getFrameText(app.nestedFramesPage().getMiddleFrame());
        Assert.assertEquals(actualText, "MIDDLE", "The top-middle frame text is not correct.");
    }

    @Test(description = "Verifies that the top-right frame text of the /nested_frames page is correct.")
    public void correct_text_for_the_top_right_frame() {
        String actualText = app.nestedFramesPage().getFrameText(app.nestedFramesPage().getRightFrame());
        Assert.assertEquals(actualText, "RIGHT", "The top-right frame text is not correct.");
    }
}
