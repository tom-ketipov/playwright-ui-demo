package pages;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NestedFramesPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(NestedFramesPage.class);
    private static final String NESTED_FRAMES_PAGE_ENDPOINT = "/nested_frames";

    public NestedFramesPage(Page page) {
        super(page);
    }

    // # page locator
    Locator title = page.locator("h3");

    Frame leftFrame = page.frame("frame-left");
    Frame middleFrame = page.frame("frame-middle");
    Frame rightFrame = page.frame("frame-right");
    Frame bottomFrame = page.frame("frame-bottom");

    // # Navigation
    public void navigate() {
        navigate(NESTED_FRAMES_PAGE_ENDPOINT);
    }

    // # Title-related Methods
    public String getTitleText() {
        logger.info("Getting title text");
        return title.innerText();
    }

    // # Frame Methods
    public Frame getLeftFrame() {
        return leftFrame;
    }

    public Frame getMiddleFrame() {
        return middleFrame;
    }

    public Frame getRightFrame() {
        return rightFrame;
    }

    public Frame getBottomFrame() {
        return bottomFrame;
    }

    public String getFrameText(Frame frame) {
        return frame.innerText("body");
    }
}