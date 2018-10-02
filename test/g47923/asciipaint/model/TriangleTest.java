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

}
