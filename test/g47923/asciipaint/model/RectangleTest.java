package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Rectangle class.
 *
 * @author g47923
 */
public class RectangleTest {

    @Test(expected = IllegalArgumentException.class)
    public void rectangleInitializationNegativeWidth() {
        Point p = new Point(2, 4);
        Rectangle r = new Rectangle(p, -4, 16, 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleInitializationNegativeHeight() {
        Point p = new Point(2, 4);
        Rectangle r = new Rectangle(p, 4, -16, 'a');
    }

    @Test
    public void rectangleInitialization() {
        Point p = new Point(2, 4);
        Rectangle r = new Rectangle(p, 4, 16, 'a');
        assertTrue(r.getUpperLeft().getX() == 2 && r.getUpperLeft().getY() == 4
                && r.getWidth() == 4 && r.getHeight() == 16 && r.getColor() == 'a');
    }

    @Test
    public void moveRectangle() {
        Point p = new Point(2, 4);
        Rectangle r = new Rectangle(p, 4, 16, 'a');
        p.move(10, 65);
        r.move(2, 4);
        assertTrue(r.getUpperLeft().getX() == 4 && r.getUpperLeft().getY() == 8);
    }

    @Test
    public void isInternalPointInside() {
        Point p = new Point(2, 4);
        Point p1 = new Point(6, 20);
        Rectangle r = new Rectangle(p, 4, 16, 'a');
        assertTrue(r.isInside(p1));
    }

    @Test
    public void isExternalPointNotInside() {
        Point p = new Point(2, 4);
        Point p1 = new Point(6, 21);
        Rectangle r = new Rectangle(p, 4, 16, 'a');
        assertFalse(r.isInside(p1));
    }

    @Test
    public void isUpperLeftPointInside() {
        Point p = new Point(2, 4);
        Rectangle r = new Rectangle(p, 4, 16, 'a');
        assertTrue(r.isInside(p));
    }

}
