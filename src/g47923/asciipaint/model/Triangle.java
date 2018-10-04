package g47923.asciipaint.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a triangle.
 *
 * @author g47923
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
    
    /**
     * Gets the surface for the given vertices. 
     * 
     * @param a is a point of a triangle.
     * @param b is a point of a triangle.
     * @param c is a point of a triangle.
     * @return the surface a of the given triangle.
     */
    //Formula used: https://www.mathopenref.com/coordtrianglearea.html.
    double surface(Point a, Point b, Point c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) 
                + b.getX() * (c.getY() - a.getY())
                + c.getX() * (a.getY() - b.getY())) / 2.0);
    }

    //https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
    @Override
    public boolean isInside(Point p) {
        double thisArea = surface(getCornerA(), getCornerB(), getCornerC());
        double pbcArea = surface(p, getCornerB(), getCornerC());
        double pacArea = surface(p, getCornerA(), getCornerC());
        double pabArea = surface(p, getCornerA(), getCornerB());
        return thisArea == (pbcArea + pacArea + pabArea);
    }

}
