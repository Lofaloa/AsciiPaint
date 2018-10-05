package g47923.asciipaint.model;

/**
 * Represents a rectangle.
 *
 * @author g47923
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Initializes this Rectangle the the given position, width, height and
     * color.
     *
     * @param upperLeft is the upper left point of this rectangle.
     * @param width is the width of this rectangle.
     * @param height is the height of this rectangle.
     * @param color is the color of this rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (height < 0) {
            throw new IllegalArgumentException(height + " is not valid, the height"
                    + " should be positive.");
        }
        if (width < 0) {
            throw new IllegalArgumentException(width + " is not valid, the width"
                    + " should be positive.");
        }
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the upperLeft point of this rectangle.
     *
     * @return the upperLeft point of this rectangle.
     */
    Point getUpperLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY());
    }

    /**
     * Gets the width of this rectangle.
     *
     * @return the width of this rectangle.
     */
    double getWidth() {
        return width;
    }

    /**
     * Gets the height of this rectangle.
     *
     * @return the height of this rectangle.
     */
    double getHeight() {
        return height;
    }

    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return upperLeft.getX() <= p.getX() && p.getX() <= upperLeft.getX() + width
                && upperLeft.getY() <= p.getY() && p.getY() <= upperLeft.getY() + height;
    }

}
