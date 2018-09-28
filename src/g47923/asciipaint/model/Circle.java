package g47923.asciipaint.model;

/**
 *
 * @author g47923
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    /**
     * Initializes this circle to the given center, radius and center.
     *
     * @param center is the center of this circle.
     * @param radius is the radius of this circle.
     * @param color is the color of this radius.
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius < 0) {
            throw new IllegalArgumentException(radius + " is not a valid radius"
                    + ", it should be positive.");
        }
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    /**
     * Gets the center of this Circle.
     *
     * @return the center of this Circle.
     */
    Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    /**
     * Gets the radius of this circle.
     *
     * @return the radius of this circle.
     */
    double getRadius() {
        return radius;
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return center.distanceTo(p) <= radius;
    }

}
