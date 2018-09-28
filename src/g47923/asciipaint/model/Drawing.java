package g47923.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a drawing.
 *
 * @author g47923
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Initializes this drawing with the given width and height. It is initially
     * empty.
     *
     * @param height is the height of this drawing.
     * @param width is the width of this drawing.
     */
    public Drawing(int height, int width) {
        if (height < 0) {
            throw new IllegalArgumentException(height + " is not valid, "
                    + "the height should be positive.");
        }
        if (width < 0) {
            throw new IllegalArgumentException(width + " is not valid, "
                    + "the height should be positive.");
        }
        this.shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * Initializes this drawing with a width and a height of 50.
     */
    public Drawing() {
        this(50, 50);
    }

    /**
     * Gets the shape of this drawing.
     *
     * @return the shape of this drawing.
     */
    List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Gets the height of this drawing.
     *
     * @return the height of this drawing.
     */
    int getHeight() {
        return height;
    }

    /**
     * Gets the width of this drawing.
     *
     * @return the width of this drawing.
     */
    int getWidth() {
        return width;
    }

    /**
     * Gets the shape containing the given point.
     *
     * @param p is the point to analyze.
     * @return the shape containing the given point.
     */
    public Shape getShapeAt(Point p) {
        return new Square(new Point(), 4, ';');
    }

    /**
     * Adds the given shape to this drawing.
     *
     * @param shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

}
