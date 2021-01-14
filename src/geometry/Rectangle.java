package geometry; /**
 * @author Amit Sharabi
 * 323784298
 */

import java.util.List;
import java.util.ArrayList;

/**
 * This class represent a rectangle object. A rectangle has width, height and the high left point. Geometry.
 * Rectangle can also calculate his intersection points with a line.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;


    /**
     * constuctor function, create a new rectangle with location and width/height.
     *
     * @param upperLeft is the high left point of the rectangle
     * @param width     is the width of the rectangle
     * @param height    is the width of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    /**
     * constructor function using an existing rectangle to create a rectangle.
     *
     * @param rectangle is a rectangle we want to duplicate
     */
    public Rectangle(Rectangle rectangle) {
        this.upperLeft = new Point(rectangle.upperLeft);
        this.width = rectangle.width;
        this.height = rectangle.height;
    }


    /**
     * the function checks if this rectangle intersect with a given line. the function returns a (possibly empty)
     * List of intersection points with the specified line.
     *
     * @param line is the line to check intersection
     * @return a List of intersection points this line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointsList = new ArrayList<>();
        Line up = new Line(this.upperLeft, new Point(this.upperLeft.getX() + width, this.upperLeft.getY()));
        Line right = new Line(up.end(), new Point(up.end().getX(), up.end().getY() + this.height));
        Line down = new Line(right.end(), new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height));
        Line left = new Line(new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height), this.upperLeft);
        if (line.isIntersecting(left)) {
            pointsList.add(line.intersectionWith(left));
        }
        if (line.isIntersecting(up)) {
            pointsList.add(line.intersectionWith(up));
        }
        if (line.isIntersecting(right)) {
            pointsList.add(line.intersectionWith(right));
        }
        if (line.isIntersecting(down)) {
            pointsList.add(line.intersectionWith(down));
        }
        return pointsList;
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The function checks if the rectangles are equal
     * @param rectangle
     * @return
     */
    /*public Boolean equals(Geometry.Rectangle rectangle){
        return this.getUpperLeft().equals(rectangle.getUpperLeft()) && getWidth() == rectangle.getWidth() &&
                getHeight() == rectangle.getHeight();
    }*/
}