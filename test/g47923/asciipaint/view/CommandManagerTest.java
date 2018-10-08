package g47923.asciipaint.view;

import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.model.Circle;
import g47923.asciipaint.model.Rectangle;
import g47923.asciipaint.model.Square;
import g47923.asciipaint.model.Triangle;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the command manager.
 *
 * @author g47923
 */
public class CommandManagerTest {

    @Test
    public void isCommandName() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertTrue(cm.isCommandName("add") && cm.isCommandName("show")
                && cm.isCommandName("remove") && cm.isCommandName("exit"));
    }

    @Test
    public void isNotCommandName() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertFalse(cm.isCommandName("quit"));
    }

    @Test
    public void isShapeName() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertTrue(cm.isShapeName("triangle") && cm.isShapeName("rectangle")
                && cm.isShapeName("circle") && cm.isShapeName("square"));
    }

    @Test
    public void isNotShapeName() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertFalse(cm.isShapeName("pentagone"));
    }

    @Test
    public void splitLine() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        String[] tokens = cm.splitLine("add circle  2   4    5     c");
        assertEquals(6, tokens.length);
        assertTrue(tokens[0].equals("add") && tokens[1].equals("circle")
                && tokens[2].equals("2")
                && tokens[3].equals("4")
                && tokens[4].equals("5")
                && tokens[5].equals("c"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseANonExistingCommand() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.requireCommandName("greet");
    }

    @Test
    public void parseAnExistingCommands() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertTrue(cm.requireCommandName("add").equals("add")
                && cm.requireCommandName("show").equals("show")
                && cm.requireCommandName("exit").equals("exit"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseANonExistingShapeName() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.requireShapeName("star");
    }

    @Test
    public void parseExistingShapeNames() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        assertTrue(cm.requireShapeName("circle").equals("circle")
                && cm.requireShapeName("square").equals("square")
                && cm.requireShapeName("rectangle").equals("rectangle")
                && cm.requireShapeName("triangle").equals("triangle"));
    }

    @Test
    public void addNewCircle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewCircle(new String[]{"0", "0", "2", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Circle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewCircleMissingArguments() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewCircle(new String[]{"0", "0", "c"});
    }

    @Test
    public void addNewRectangle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewRectangle(new String[]{"0", "0", "2", "3", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Rectangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewRectangleMissingArguments() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewRectangle(new String[]{"0", "0", "c"});
    }

    @Test
    public void addNewSquare() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewSquare(new String[]{"0", "0", "2", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Square);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewSquareMissingArguments() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewSquare(new String[]{"0", "0"});
    }

    @Test
    public void addNewTriangle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewTriangle(new String[]{"0", "0", "1", "2", "3", "4", "t"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Triangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewTriangleMissingArguments() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewTriangle(new String[]{"3", "4", "t"});
    }

    @Test
    public void addNewShape_ShapeIsACircle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("circle", new String[]{"0", "0", "2", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Circle);
    }

    @Test
    public void addNewShape_ShapeIsARectangle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("rectangle", new String[]{"0", "0", "2", "3", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Rectangle);
    }

    @Test
    public void addNewShape_ShapeIsASquare() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("square", new String[]{"0", "0", "2", "c"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Square);
    }

    @Test
    public void addNewShape_ShapeIsATriangle() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("triangle", new String[]{"0", "0", "1", "2", "3", "4", "t"});
        assertTrue(cm.getDrawing().getShapes().get(0) instanceof Triangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewShape_NotExistingShape() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("pentagone", new String[]{"0", "0", "1", "2", "3", "4", "t"});
    }

    @Test
    public void removeShapeAt() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.addNewShape("rectangle", new String[]{"0", "0", "2", "3", "c"});
        cm.removeShapeAt("0", "0");
        assertTrue(cm.getDrawing().getShapes().isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void removeShapeAtNoShapes() {
        CommandManager cm = new CommandManager(new AsciiPaint());
        cm.removeShapeAt("0", "0");
        assertTrue(cm.getDrawing().getShapes().isEmpty());
    }

}
