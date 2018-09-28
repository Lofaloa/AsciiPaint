package g47923.asciipaint.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the Drawing class.
 *
 * @author g47923
 */
public class DrawingTest {

    @Test
    public void drawingInitializationGivenWidthAndHeight() {
        Drawing d = new Drawing(100, 30);
        assertTrue(d.getWidth() == 30 && d.getHeight() == 100);
    }

    @Test
    public void drawingInitializationNoGivenWidthAndHeight() {
        Drawing d = new Drawing();
        assertTrue(d.getWidth() == 50 && d.getHeight() == 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawingInitializationNegativeWidth() {
        Drawing d = new Drawing(-100, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawingInitializationNegativeHeight() {
        Drawing d = new Drawing(100, -30);
    }

    @Test
    public void getShapeAt() {
        //TO IMPLEMENT
    }

    @Test
    public void addShape() {
        Drawing d = new Drawing(100, 30);
        Shape shape = new Square(new Point(), 5, 'x');
        d.addShape(shape);
        assertEquals(1, d.getShapes().size());
    }
}
