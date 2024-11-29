package ui.pages;

import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class DragAndDropTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        app().dragAndDropPage().navigate();
    }

    @Test(description = "Verifies that the '/drag-and-drop' page title text is correct.")
    public void correct_title_for_the_drag_and_drop_page() {
        String actualTitle = app().dragAndDropPage().getTitleText();
        String expectedTitle = "Drag and Drop";

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected page title '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verify that the user can perform drag-n-drop actions with the dragTo() method.")
    public void can_drag_and_drop_element_with_drag_to_method() {
        Locator columnA = app().dragAndDropPage().getColumnA();
        Locator columnB = app().dragAndDropPage().getColumnB();

        app().dragAndDropPage().dragAndDrop(columnA, columnB); // Method name optimized

        Assert.assertEquals(columnA.innerText(), "B", "Expected text in Column A to be 'B'");
        Assert.assertEquals(columnB.innerText(), "A", "Expected text in Column B to be 'A'");
    }

    @Test(description = "Verify that the user can perform drag-n-drop actions manually.")
    public void can_drag_and_drop_element_manually() {
        Locator columnA = app().dragAndDropPage().getColumnA();
        Locator columnB = app().dragAndDropPage().getColumnB();

        app().dragAndDropPage().dragAndDropManually(columnA, columnB); // Method name optimized

        Assert.assertEquals(columnA.innerText(), "B", "Expected text in Column A to be 'B'");
        Assert.assertEquals(columnB.innerText(), "A", "Expected text in Column B to be 'A'");
    }
}