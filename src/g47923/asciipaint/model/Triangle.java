package g47923.asciipaint.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a triangle.
 *
 * @author logan
 */
public class Triangle extends ColoredShape {

    private final List<Point> corners;

    /**
     * Initializes this triangle with three points.
     *
     * @param a is a point of this triangle.
     * @param b is a point of this triangle.
     * @param c is a point of this triangle.
     * @param color is the color of this triangle.
     */
    public Triangle(Point a, Point b, Point c, char color) {
        super(color);
        this.corners = new ArrayList<>(Arrays.asList(new Point(a.getX(), a.getY()),
                new Point(b.getX(), b.getY()),
                new Point(c.getX(), c.getY())));
    }

    /**
     * Gets a corner A of this triangle.
     *
     * @return corner A of this triangle.
     */
    Point getCornerA() {
        return new Point(corners.get(0).getX(), corners.get(0).getY());
    }

    /**
     * Gets a corner B of this triangle.
     *
     * @return corner B of this triangle.
     */
    Point getCornerB() {
        return new Point(corners.get(1).getX(), corners.get(1).getY());

    }

    /**
     * Gets a corner C of this triangle.
     *
     * @return corner C of this triangle.
     */
    Point getCornerC() {
        return new Point(corners.get(2).getX(), corners.get(2).getY());
    }

    @Override
    public void move(double dx, double dy) {
        for (Point corner : corners) {
            corner.move(dx, dy);
        }
    }

    @Override
    public boolean isInside(Point p) {
        return true;
    }

}
