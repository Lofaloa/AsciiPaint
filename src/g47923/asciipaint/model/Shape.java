package g47923.asciipaint.model;

/**
 * Represents a shape. 
 *
 * @author g47923
 */
public interface Shape {
    
    /**
     * Moves this Shape.
     * 
     * @param dx is the difference added to x position.
     * @param dy is the difference added to y position.
     * @return this Shape with the given position.
     */
    Shape move(double dx, double dy);
    
    /**
     * Tells if the given point is in this shape.
     * 
     * @param p is the point to tell if it is in this shape.
     * @return true if the given point is in this shape.
     */
    boolean isInside(Point p);
    
    /**
     * Gets the color of this shape.
     * 
     * @return the color of this shape.
     */
    char getColor();
}
