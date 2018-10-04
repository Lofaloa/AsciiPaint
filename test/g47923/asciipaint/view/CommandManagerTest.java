package g47923.asciipaint.view;

import g47923.asciipaint.model.AsciiPaint;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the command manager.
 *
 * @author g47923
 */
public class CommandManagerTest {

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
    public void parseAExistingCommands() {
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

}
