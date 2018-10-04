package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the triangle class.
 *
 * @author g47923
 */
public class TriangleTest {

    @Test
    public void triangleInitialization() {
        Point p = new Point(2, 10);
        Point p1 = new Point(0, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertTrue(t.getCornerA().getX() == 2 && t.getCornerA().getY() == 10
                && t.getCornerB().getX() == 0 && t.getCornerB().getY() == 5
                && t.getCornerC().getX() == 4 && t.getCornerC().getY() == 5
                && t.getColor() == 't');
    }

    @Test
    public void moveTriangle() {
        Point p = new Point(2, 10);
        Point p1 = new Point(0, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        t.move(2, 4);
        assertTrue(t.getCornerA().getX() == 4 && t.getCornerA().getY() == 14
                && t.getCornerB().getX() == 2 && t.getCornerB().getY() == 9
                && t.getCornerC().getX() == 6 && t.getCornerC().getY() == 9);
    }

    @Test
    public void surface() {
        Point p = new Point(4, 10);
        Point p1 = new Point(8, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertEquals(10, t.surface(t.getCornerA(), t.getCornerB(), t.getCornerC()), 0);
    }

    @Test
    public void surfaceTriangleIsAPoint() {
        Point p = new Point(0, 0);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertEquals(0, t.surface(t.getCornerA(), t.getCornerB(), t.getCornerC()), 0);
    }

    @Test
    public void cornersAreInsideTriangle() {
        Point p = new Point(4, 10);
        Point p1 = new Point(8, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertTrue(t.isInside(p) && t.isInside(p1) && t.isInside(p2));
    }
    
    @Test
    public void pointIsInsideTriangle() {
        Point p = new Point(4, 10);
        Point p1 = new Point(8, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertTrue(t.isInside(new Point(6, 6)));
    }
    
    @Test
    public void pointIsNotInsideTriangle() {
        Point p = new Point(4, 10);
        Point p1 = new Point(8, 5);
        Point p2 = new Point(4, 5);
        Triangle t = new Triangle(p, p1, p2, 't');
        assertFalse(t.isInside(new Point(5, 9)));
    }

}
