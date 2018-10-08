package g47923.asciipaint.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a drawing.
 *
 * @author g47923
 */
class Drawing {

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
    public Drawing(int width, int height) {
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
    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
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
     * @return the shape containing the given point, if no shape is found null
     * is returned.
     */
    public Shape getShapeAt(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Adds the given shape to this drawing.
     *
     * @param shape is the shape to add.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Removes the given shape from this drawing.
     *
     * @param shape is the shape to remove.
     */
    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * Adds the given shapes to this drawing.
     *
     * @param shapes are the shapes to add.
     */
    void addAllShapes(Shape ...shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

}
