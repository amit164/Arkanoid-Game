package geometry; /**
 * @author Amit Sharabi
 * 323784298
 */

/**
 * This class represent a point object. A point has an x and a y value, and can measure the distance to other points,
 * and if it is equal to another point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor function using x an y values to create a point.
     *
     * @param x is x value for point
     * @param y is y value for point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * constructor function using an existing point to create a point.
     *
     * @param other is a point we want to duplicate
     */
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * the function returns the distance of this point to another.
     *
     * @param other is a point we calculate the distance with this point
     * @return the distance between the points
     */
    public double distance(Point other) {
        double deltaX = this.x - other.x; //the difference between the x values
        double deltaY = this.y - other.y; //the difference between the y values
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * the function checks if this point is equal to other point.
     *
     * @param other is a point we compare with
     * @return True if the points are equal, False otherwise
     */
    public boolean equals(Point other) {
        return ((this.x == other.x) && (this.y == other.y));
    }

    /**
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}
