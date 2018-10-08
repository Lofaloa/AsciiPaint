package g47923.asciipaint.model;

/**
 * Represents a point.
 *
 * @author g47923
 */
class Point {

    private double x;
    private double y;

    /**
     * Initializes this point to the given x and y.
     *
     * @param x is the x position of this Point.
     * @param y is the y position of this Point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes this x and y position point to 0
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Gets the x position of this point.
     *
     * @return the x position of this point.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y position of this point.
     *
     * @return the y position of this point.
     */
    public double getY() {
        return y;
    }

    /**
     * Moves this point position.
     *
     * @param dx is the x difference to add to this x position.
     * @param dy is the y difference to add to this y position.
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Gets the distance between this point and an other.
     *
     * @param other is the point to evaluate the distance to.
     * @return the distance between this point and an other.
     */
    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.getX() - x, 2)
                + Math.pow((other.getY() - y), 2));
    }

}
