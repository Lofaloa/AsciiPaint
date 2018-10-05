package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the AsciiPaint class.
 *
 * @author Logan
 */
public class AsciiPaintTest {

    @Test
    public void initilizationWithoutArguments() {
        AsciiPaint ap = new AsciiPaint();
        assertTrue(ap.getDrawing().getHeight() == 50
                && ap.getDrawing().getWidth() == 50
                && ap.getDrawing().getShapes().isEmpty());
    }

    @Test
    public void initilizationWithEmptyDrawing() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        assertTrue(ap.getDrawing().getHeight() == 100
                && ap.getDrawing().getWidth() == 30
                && ap.getDrawing().getShapes().isEmpty()
                && ap.getDrawing() != d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initilizationWithNotEmptyDrawing() {
        Drawing d = new Drawing(100, 30);
        d.addShape(new Square(new Point(), 4, 'a'));
        AsciiPaint ap = new AsciiPaint(d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCircleNegativeRadius() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newCircle(0, 0, -4, 'a');
    }

    public void newCircleAddedToDrawing() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newCircle(0, 0, 4, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Circle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newRectangleNegativeHeight() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newRectangle(0, 0, 5, -4, 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void newRectangleNegativeWidth() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newRectangle(0, 0, -5, 4, 'a');
    }

    public void newRectangleAddedToDrawing() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newRectangle(0, 0, 3, 5, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Rectangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSquareNegativeSide() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newSquare(0, 0, -1, 'a');
    }

    @Test
    public void newSquareAddedToDrawing() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newSquare(0, 0, 2, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Square);
    }

    @Test
    public void newTriangleAdded() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newTriangle(1, 2, 3, 4, 5, 6, 't');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Triangle);
    }

    @Test
    public void removeShape() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        ap.newTriangle(1, 2, 3, 4, 5, 6, 't');
        ap.newSquare(0, 0, 2, 'a');
        ap.removeShapeAt(new Point(1, 1));
        ap.removeShapeAt(new Point(1, 2));
        assertTrue(ap.getDrawing().getShapes().isEmpty());
    }
    
    @Test
    public void testAsAscii() {
        Drawing d = new Drawing(100, 30);
        AsciiPaint ap = new AsciiPaint(d);
        assertFalse(ap.asAscii().isEmpty());
    }

}
