package g47923.asciipaint.model;

/**
 * Represents the game.
 *
 * @author g47923
 */
public class AsciiPaint {

    private final Drawing drawing;

    /**
     * Initializes this game with a empty blank drawing of 50 x 50;
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Initializes this game with a given blank drawing.
     *
     * @param drawing is the drawing of this game.
     * @throws IllegalArgumentException if the given drawing is not empty.
     */
    public AsciiPaint(Drawing drawing) {
        if (!drawing.getShapes().isEmpty()) {
            throw new IllegalArgumentException("The drawing should be empty.");
        }
        this.drawing = new Drawing(drawing.getHeight(), drawing.getWidth());
    }

    /**
     * Gets this game drawing.
     *
     * @return this game drawing.
     */
    Drawing getDrawing() {
        return drawing;
    }

    /**
     * Adds a new circle to this game drawing.
     *
     * @param x is the x position of the circle center.
     * @param y is the y position of the circle center.
     * @param radius is the size of the circle radius.
     * @param color is the color of the circle.
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Adds a new rectangle to this game drawing.
     *
     * @param x is the x position of the rectangle upper left point.
     * @param y is the y position of the rectangle upper left point.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     * @param color is the color of the rectangle.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Adds a new square to this game drawing.
     *
     * @param x is the x position of the square upper left point.
     * @param y is the y position of the square left point.
     * @param side is the side of the square.
     * @param color is the color of the square.
     */
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

    /**
     * Adds a new triangle to this drawing.
     *
     * @param x1 is the x position of the triangle first corner.
     * @param y1 is the y position of the triangle first corner.
     * @param x2 is the x position of the triangle second corner.
     * @param y2 is the y position of the triangle second corner.
     * @param x3 is the x position of the triangle third corner.
     * @param y3 is the y position of the triangle third corner.
     * @param color is the color of the new triangle.
     */
    public void newTriangle(int x1, int y1, int x2, int y2, int x3, int y3,
             char color) {
        drawing.addAllShapes(new Triangle(new Point(x1, y1), new Point(x2, y2),
                new Point(x3, y3), color));
    }

    /**
     * Represents this game drawing.
     *
     * @return a representation of this game drawing.
     */
    public String asAscii() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < drawing.getHeight(); i++) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                Point currentPoint = new Point(i, j);
                Shape s = drawing.getShapeAt(currentPoint);
                if (s != null && s.isInside(currentPoint)) {
                    builder.append(s.getColor());
                } else {
                    builder.append(' ');
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }

}
