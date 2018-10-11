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
        assertTrue(d.getWidth() == 100 && d.getHeight() == 30);
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
        Drawing d = new Drawing(100, 30);
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
        assertTrue(d.getShapeAt(new Point(0, 0)) instanceof Circle);
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
        d.add(shape);
        assertTrue(1 == d.getShapes().size()
                && d.getShapes().get(0) instanceof Square);
    }

    @Test
    public void moveRectangle() {
        Drawing d = new Drawing(100, 30);
        Rectangle r = new Rectangle(new Point(), 3, 6, 'r');
        d.add(r);
        d.move(r, 2, 2);
        assertTrue(r.getUpperLeft().getX() == 2 && r.getUpperLeft().getY() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveNotAddedRectangle() {
        Drawing d = new Drawing(100, 30);
        Rectangle r = new Rectangle(new Point(), 3, 6, 'r');
        d.move(r, 2, 2);
    }

    @Test
    public void moveSquare() {
        Drawing d = new Drawing(100, 30);
        Square s = new Square(new Point(), 6, 's');
        d.add(s);
        d.move(s, 2, 2);
        assertTrue(s.getUpperLeft().getX() == 2 && s.getUpperLeft().getY() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveNotAddedSquare() {
        Drawing d = new Drawing(100, 30);
        Square s = new Square(new Point(), 6, 's');
        d.move(s, 2, 2);
    }

    @Test
    public void moveCircle() {
        Drawing d = new Drawing(100, 30);
        Circle c = new Circle(new Point(), 6, 'c');
        d.add(c);
        d.move(c, 2, 2);
        assertTrue(c.getCenter().getX() == 2 && c.getCenter().getY() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveNotAddedCircle() {
        Drawing d = new Drawing(100, 30);
        Circle c = new Circle(new Point(), 6, 'c');
        d.move(c, 2, 2);
    }

    @Test
    public void moveTriangle() {
        Drawing d = new Drawing(100, 30);
        Triangle t = new Triangle(new Point(), new Point(1, 1), new Point(2, 2), 't');
        d.add(t);
        d.move(t, 2, 2);
        assertTrue(t.getCornerA().getX() == 2 && t.getCornerA().getY() == 2
                && t.getCornerB().getX() == 3 && t.getCornerB().getY() == 3
                && t.getCornerC().getX() == 4 && t.getCornerC().getY() == 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moveNotAddedTriangle() {
        Drawing d = new Drawing(100, 30);
        Triangle t = new Triangle(new Point(), new Point(1, 1), new Point(2, 2), 't');
        d.move(t, 2, 2);
    }

    @Test
    public void removeShape() {
        Drawing d = new Drawing(100, 30);
        Shape shape = new Square(new Point(), 5, 'x');
        d.add(shape);
        d.remove(shape);
        assertTrue(d.getShapes().isEmpty());
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
