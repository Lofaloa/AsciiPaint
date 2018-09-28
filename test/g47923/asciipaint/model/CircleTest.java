package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the Circle class.
 *
 * @author g47923
 */
public class CircleTest {

    @Test
    public void circleInitialization() {
        Point p = new Point(2, 4);
        Circle c = new Circle(p, 4, 'a');
        assertTrue(c.getCenter().getX() == 2 && c.getCenter().getY() == 4
                && c.getRadius() == 4 && c.getColor() == 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void circleInitializationNegativeRadius() {
        Point p = new Point(2, 4);
        Circle c = new Circle(p, -4, 'a');
        assertTrue(c.getCenter().getX() == 2 && c.getCenter().getY() == 4
                && c.getRadius() == 4 && c.getColor() == 'a');
    }

    @Test
    public void getCenterIsACopy() {
        Point p = new Point(2, 4);
        Circle c = new Circle(p, 4, 'a');
        assertFalse(p == c.getCenter());
    }

    @Test
    public void moveCircleCenterIsImmutable() {
        Point p = new Point(2, 4);
        Circle c = new Circle(p, 4, 'a');
        p.move(21, 5);
        c.move(1, 4);
        assertTrue(c.getCenter().getX() == 3 && c.getCenter().getY() == 8);
    }

    @Test
    public void internalPointIsInside() {
        Point p = new Point(1, 4);
        Point p1 = new Point(2, 4);
        Circle c = new Circle(p, 4, 'a');
        assertTrue(c.isInside(p1));
    }

    @Test
    public void centerIsInside() {
        Point p = new Point(1, 4);
        Circle c = new Circle(p, 4, 'a');
        assertTrue(c.isInside(p));
    }

    @Test
    public void externalPointIsNotInside() {
        Point p = new Point(1, 4);
        Point p1 = new Point(32, 4);
        Circle c = new Circle(p, 4, 'a');
        assertFalse(c.isInside(p1));
    }

}
