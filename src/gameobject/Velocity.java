package gameobject; /**
 * @author Amit Sharabi
 * 323784298
 */

import geometry.Point;

/**
 * This class represent velocity object. A velocity has delta x and delta y, and can move a point to other x and y
 * values by this dx and dy.
 */
public class Velocity {
    private double dx;
    private double dy;

    private static final int TO_CALCULATE_SPEED = -1;

    /**
     * constructor function using delta x and delta y to create velocity object.
     *
     * @param dx is the delta in x axes
     * @param dy is the delta in y axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * constructor function using an existing velocity to create a velocity.
     *
     * @param v is a velocity we want to duplicate
     */
    public Velocity(Velocity v) {
        this.dx = v.dx;
        this.dy = v.dy;
    }

    /**
     * The function creates new velocity using an angle and a speed.
     *
     * @param angle is the movement angle
     * @param speed is the velocity
     * @return a new velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle) * TO_CALCULATE_SPEED;
        return new Velocity(dx, dy);
    }

    /**
     * @return delta x
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return delta y
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * @param x is the new delta x to set
     */
    public void setDx(double x) {
        this.dx = x;
    }

    /**
     * @param y is the new delta y to set
     */
    public void setDy(double y) {
        this.dy = y;
    }

    /**
     * the function take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p is a point to move
     * @return a new point with new positions
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}
