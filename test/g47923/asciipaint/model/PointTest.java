package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Point class.
 *
 * @author g47923
 */
public class PointTest {

    @Test
    public void pointInitializationWithArguments() {
        Point p = new Point(1, 2);
        assertTrue(p.getX() == 1 && p.getY() == 2);
    }

    @Test
    public void pointInitializationNoArguments() {
        Point p = new Point();
        assertTrue(p.getX() == 0 && p.getY() == 0);
    }

    @Test
    public void movePoint() {
        Point p = new Point(1, 2);
        p.move(2, 4);
        assertTrue(p.getX() == 3 && p.getY() == 6);
    }

    @Test
    public void getDistanceBetweenTwoPoint() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 2);
        assertEquals(2.0, p1.distanceTo(p2), 0);
    }

    @Test
    public void getDistanceBetweenTwoEqualPoint() {
        Point p1 = new Point();
        Point p2 = new Point();
        assertEquals(0.0, p1.distanceTo(p2), 0);
    }

}
