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
        new Drawing(-100, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawingInitializationNegativeHeight() {
        new Drawing(100, -30);
    }

    /**
     * Tests the number of shapes we get, then tests class encapsulation.
     */
    @Test
    public void getShapes() {
        Drawing d = new Drawing();
        Shape square = new Square(new Point(), 5, 'x');
        Shape circle = new Circle(new Point(3, 2), 5, 'x');
        Shape rectangle = new Rectangle(new Point(1, 3), 5, 4, 'x');
        d.addAllShapes(square, rectangle, circle);
        assertEquals(3, d.getShapes().size());
        assertFalse(square != d.getShapes().get(0)
                && rectangle != d.getShapes().get(1)
                && circle != d.getShapes().get(2));
    }

    @Test
    public void getShapeAt() {
        Drawing d = new Drawing(100, 30);
        Shape square = new Square(new Point(), 5, 'x');
        Shape circle = new Circle(new Point(3, 2), 5, 'x');
        Shape rectangle = new Rectangle(new Point(1, 3), 5, 4, 'x');
        d.addAllShapes(square, rectangle, circle);
        assertTrue(d.getShapeAt(new Point(0, 0)) instanceof Square);
    }

    @Test
    public void getShapeAtExternalPoint() {
        Drawing d = new Drawing(100, 30);
        Shape square = new Square(new Point(), 5, 'x');
        Shape circle = new Circle(new Point(3, 2), 5, 'x');
        Shape rectangle = new Rectangle(new Point(1, 3), 5, 4, 'x');
        d.addAllShapes(square, rectangle, circle);
        assertTrue(d.getShapeAt(new Point(32, 54)) == null);
    }

    @Test
    public void addShape() {
        Drawing d = new Drawing(100, 30);
        Shape shape = new Square(new Point(), 5, 'x');
        d.addShape(shape);
        assertTrue(1 == d.getShapes().size()
                && d.getShapes().get(0) instanceof Square);
    }

    @Test
    public void addShapes() {
        Drawing d = new Drawing(100, 30);
        Shape square = new Square(new Point(), 5, 'x');
        Shape circle = new Circle(new Point(3, 2), 5, 'x');
        Shape rectangle = new Rectangle(new Point(1, 3), 5, 4, 'x');
        d.addAllShapes(square, rectangle, circle);
        assertEquals(3, d.getShapes().size());
    }
}
