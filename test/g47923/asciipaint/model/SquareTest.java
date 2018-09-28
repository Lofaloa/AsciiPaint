package g47923.asciipaint.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Logan
 */
public class SquareTest {

    @Test
    public void squareInitialization() {
        Point p = new Point(2, 4);
        Square s = new Square(p, 4, 'a');
        assertTrue(s.getUpperLeft().getX() == 2 && s.getUpperLeft().getY() == 4
                && s.getWidth() == 4 && s.getColor() == 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void squareInitializationNegativeSide() {
        Point p = new Point(2, 4);
        Square s = new Square(p, -4, 'a');
    }

}
