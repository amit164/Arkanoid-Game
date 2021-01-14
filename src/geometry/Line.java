package geometry;

import java.util.List;

/**
 * @author Amit Sharabi
 * 323784298
 */


/**
 * This class represent a line object. A line (actually a line-segment) connects two points - a start point and an
 * end point. Lines have lengths, and may intersect with other lines and rectangles. It can also tell if it is the same
 * as another line segment.
 */
public class Line {
    private Point start;
    private Point end;

    private static final double EP = Math.pow(10, -10);


    /**
     * constructor function using two points to create a line.
     *
     * @param start is the start point
     * @param end   is the end point
     */
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    /**
     * constructor function using two points to create a line.
     *
     * @param x1 is x value for start point
     * @param y1 is y value for start point
     * @param x2 is x value for end point
     * @param y2 is y value for end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * the function return the middle point of the line.
     *
     * @return middle point
     */
    public Point middle() {
        double xValue = (this.start.getX() + this.end.getX()) / 2;
        double yValue = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xValue, yValue);
    }

    /**
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the function checks if this line is equal to other line.
     *
     * @param other is a line we compare with
     * @return True if the lines are equal, False otherwise
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * the function returns if this x meeting value is in range of the lines.
     *
     * @param x is meeting value for endless lines
     * @return True if x in , False otherwise
     */
    public boolean inXRange(Double x) {
        return (this.start.getX() - EP <= x && x <= this.end.getX() + EP) || (this.start.getX() + EP >= x && x
                >= this.end.getX() - EP);
    }

    /**
     * the function returns if this y meeting value is in range of the lines.
     *
     * @param y is meeting value for endless lines
     * @return True if y in , False otherwise
     */
    public boolean inYRange(Double y) {
        return (this.start.getY() - EP <= y && y <= this.end.getY() + EP) || (this.start.getY() + EP >= y && y
                >= this.end.getY() - EP);
    }

    /**
     * The function checks if a point is in range of other line.
     *
     * @param p is the point to check
     * @return True if the point is in the line range, and False otherwise.
     */
    public boolean isPointInRange(Point p) {
        return this.inXRange(p.getX()) && this.inYRange(p.getY());
    }

    /**
     * the function checks is one line is a continues of the other one and return the point where they "meet".
     *
     * @param other is the line to check on
     * @return the point in which the lines continue one another (if one is a continues of the other),and null
     * otherwise)
     */
    public Point isOneContinueAnother(Line other) {
        //if the start of line is in range of the other line
        if (this.isPointInRange(other.start())) {
            //if the end of line is in also in range of the other line, it mean's that the lines don't intersect
            if (this.isPointInRange(other.end())) {
                return null;
            }
            //if the start of the line is also the start or the end of the other
            if (this.start().equals(other.start()) || this.end().equals(other.start())) {
                return other.start();
            }
        }
        //if the end of line is in range of the other line
        if (this.isPointInRange(other.end())) {
            //if the start of line is in also in range of the other line, it mean's that the lines don't intersect
            if (this.isPointInRange(other.start())) {
                return null;
            }
            //if the end of the line is also the start or the end of the other
            if (this.start().equals(other.end()) || this.end().equals(other.end())) {
                return other.end();
            }
        }
        //if the start of line is in range of the other line
        if (other.isPointInRange(this.start())) {
            //if the end of line is in also in range of the other line, it mean's that the lines don't intersect
            if (other.isPointInRange(this.end())) {
                return null;
            }
            //if the start of the line is also the start or the end of the other
            if (other.start().equals(this.start()) || other.end().equals(this.start())) {
                return this.start();
            }
        }
        //if the end of line is in range of the other line
        if (other.isPointInRange(this.end())) {
            //if the start of line is in also in range of the other line, it mean's that the lines don't intersect
            if (other.isPointInRange(this.start())) {
                return null;
            }
            //if the end of the line is also the start or the end of the other
            if (other.start().equals(this.end()) || other.end().equals(this.end())) {
                return this.end();
            }
        }
        return null;
    }

    /**
     * the function checks is one line is a continues of the other one and return the point where they "meet".
     *
     * @param other is line to compare
     * @return the point in which the lines continue one another (if one is a continues of the other),and null
     * otherwise)
     */
    public Point isContinuing(Line other) {
        if (this.isOneContinueAnother(other) != null && other.isOneContinueAnother(this) != null) {
            if (this.isOneContinueAnother(other).equals(other.isOneContinueAnother(this))) {
                return this.isOneContinueAnother(other);
            }
        }
        return null;
    }

    /**
     * @return the gradient of this line.
     */
    public double findGradient() {
        return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    }

    /**
     * @return the Y intercept of this line.
     */
    public double findYIntercept() {
        return (this.start.getY() - this.findGradient() * this.start.getX());
    }

    /**
     * the function returns the y value of the line in a given x.
     *
     * @param x value to find the y
     * @return y value of the line in x
     */
    public double yValueInX(double x) {
        return this.findGradient() * x + this.findYIntercept();
    }

    /**
     * the function help the function isIntersecting to find the intersection point in endless lines.
     *
     * @param other is a line to check intersection with
     * @return point if the lines intersecting, null otherwise
     */
    public Point isIntersectingValue(Line other) {
        double m1, m2, b1, b2;
        m1 = this.findGradient();
        m2 = other.findGradient();
        b1 = this.findYIntercept();
        b2 = other.findYIntercept();
        if (m1 == m2) {
            return this.isContinuing(other);
        }
        return new Point((b2 - b1) / (m1 - m2), this.yValueInX((b2 - b1) / (m1 - m2)));
    }

    /**
     * the function dived the intersection to 3 cases: when both of them vertical to the X line, when only one of the
     * lines is vertical to X line, and the last is any other case that we can handle in the same way.
     *
     * @param other is a line to check intersection with
     * @return True if the lines intersect, False otherwise
     */
    public boolean isIntersecting(Line other) {
        //a case when both of lines are vertical to x line
        if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
            if (this.start.getX() != other.start.getX()) {
                return false;
            }
            return this.isContinuing(other) != null;
        }
        //a case when only one of lines are vertical to x line
        if (this.start.getX() == this.end.getX()) {
            if (other.inXRange(this.start.getX())) {
                return this.inYRange(other.yValueInX(this.start.getX()));
            }
            return false;
        }
        if (other.start.getX() == other.end.getX()) {
            if (this.inXRange(other.start.getX())) {
                return other.inYRange(this.yValueInX(other.start.getX()));
            }
            return false;
        }
        //any other case
        Point p = this.isIntersectingValue(other);
        if (p == null) {
            return false;
        }
        return this.inXRange(p.getX()) && other.inXRange(p.getX()) && this.inYRange(p.getY())
                && other.inYRange(p.getY());
    }

    /**
     * the function checks if the lines intersect and return the intersection point by diving the options for
     * intersection to 3 cases: if both of the lines are vertical to X axis, if only one of the lines is vertical to X
     * axis and any other case handled in the same way. If the lines don't intersect,the function returns null.
     *
     * @param other is a line to check intersection with
     * @return the intersection point if the lines intersect, and null otherwise
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
                return this.isContinuing(other);
            }
            if (this.start.getX() == this.end.getX()) {
                return new Point(this.start.getX(), other.yValueInX(this.start.getX()));
            }
            if (other.start.getX() == other.end.getX()) {
                return new Point(other.start.getX(), this.yValueInX(other.start.getX()));
            }
            return this.isIntersectingValue(other);
        }
        return null;
    }

    /**
     * the function checks if this line intersect with the rectangle. If this line does not intersect with the
     * rectangle return null.Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect is a rectangle to check intersection
     * @return the closest intersection point to the start of the line, and null if the line does'nt intersect with
     * the rectangle
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pointsList = rect.intersectionPoints(this);
        Point close = null;
        double dis = Double.MAX_VALUE;
        for (Point point : pointsList) {
            //compare the distance to the closest point
            if (this.start.distance(point) < dis) {
                close = new Point(point);
                dis = this.start.distance(point);
            }
        }
        return close;
    }
}
