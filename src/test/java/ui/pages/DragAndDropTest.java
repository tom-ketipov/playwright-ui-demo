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
        app.dragAndDropPage().navigate();
    }

    @Test(description = "Verifies that the '/drag-and-drop' page title text is correct.")
    public void correct_title_for_the_drag_and_drop_page() {
        String actualTitle = app.dragAndDropPage().getTitleText();
        String expectedTitle = "Drag and Drop";

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("Expected page title '%s', but got '%s'", expectedTitle, actualTitle));
    }

    @Test(description = "Verify that the user can perform drag-n-drop actions with the dragTo() method.")
    public void can_drag_and_drop_element_with_drag_to_method() {
        Locator firstColumnElement = app.dragAndDropPage().getColumnA();
        Locator secondColumnElement = app.dragAndDropPage().getColumnB();

        app.dragAndDropPage().dragAndDrop(firstColumnElement, secondColumnElement);

        String columnAText = "A";
        String columnBText = "B";

        Assert.assertEquals(firstColumnElement.innerText(), columnBText,
                String.format("Expected first column to have text '%s', but got '%s'", columnBText, firstColumnElement.innerText()));
        Assert.assertEquals(secondColumnElement.innerText(), columnAText,
                String.format("Expected second column to have text '%s', but got '%s'", columnAText, secondColumnElement.innerText()));
    }

    @Test(description = "Verify that the user can perform drag-n-drop actions manually.")
    public void can_drag_and_drop_element_manually() {
        Locator firstColumnElement = app.dragAndDropPage().getColumnA();
        Locator secondColumnElement = app.dragAndDropPage().getColumnB();

        app.dragAndDropPage().dragAndDropManually(firstColumnElement, secondColumnElement);

        String columnAText = "A";
        String columnBText = "B";

        Assert.assertEquals(firstColumnElement.innerText(), columnBText,
                String.format("Expected first column to have text '%s', but got '%s'", columnBText, firstColumnElement.innerText()));
        Assert.assertEquals(secondColumnElement.innerText(), columnAText,
                String.format("Expected second column to have text '%s', but got '%s'", columnAText, secondColumnElement.innerText()));
    }
}