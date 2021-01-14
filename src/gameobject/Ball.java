package gameobject; /**
 * @author Amit Sharabi
 * 323784298
 */

import gamearkanoid.CollisionInfo;
import gamearkanoid.GameLevel;
import gamearkanoid.GameEnvironment;
import geometry.Line;
import geometry.Point;
import graphics.SnowFlake;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Sharabi
 * 323784298
 */

/**
 * This class represent a ball object. A ball has center point, size, color and his game environment. A ball also know
 * how to draw themselves on a DrawSurface and to move on the screen game.
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private int size;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment game;
    private List<HitListener> hitListeners;
    private SnowFlake snowFlake;

    private static final int CHANGE_VELOCITY = -1;
    private static final int OPTIONAL_COLLISION = 4;
    private static final int SIZE_OF_PIXEL = 1;

    /**
     * constructor function using a point, radius and a color to create a ball.
     *
     * @param center is the center point of the ball
     * @param r      is the radius of the ball
     * @param color  is the ball's color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = new Point(center);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * constructor function using x and y values for the center point, radius and color to create a ball.
     *
     * @param x     is the x value of the ball's center point
     * @param y     is the y value of the ball's center point
     * @param r     is the radius of the ball
     * @param color is the ball's color
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * constructor function using a point, radius, color and a velocity to create a ball.
     *
     * @param center is the center point of the ball
     * @param r      is the radius of the ball
     * @param color  is the ball's color
     * @param v      is the ball's velocity
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v) {
        this.center = new Point(center);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(v);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * constructor function using a point, radius, color, dx and dy to create a ball.
     *
     * @param center is the center point of the ball
     * @param r      is the radius of the ball
     * @param color  is the ball's color
     * @param dx     is the ball's dx velocity
     * @param dy     is the ball's dy velocity
     */
    public Ball(Point center, int r, java.awt.Color color, int dx, int dy) {
        this.center = new Point(center);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(dx, dy);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * constructor function using x and y values for the center point, radius, color and velocity to create a ball.
     *
     * @param x     is the x value of the ball's center point
     * @param y     is the y value of the ball's center point
     * @param r     is the radius of the ball
     * @param color is the ball's color
     * @param v     is the ball's velocity
     */
    public Ball(int x, int y, int r, java.awt.Color color, Velocity v) {
        this.center = new Point(x, y);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(v);
        this.game = new GameEnvironment();
        this.hitListeners = new ArrayList<>();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * constructor function using x and y values for the center point, radius, color, dx and dy to create a ball.
     *
     * @param x     is the x value of the ball's center point
     * @param y     is the y value of the ball's center point
     * @param r     is the radius of the ball
     * @param color is the ball's color
     * @param dx    is the ball's dx velocity
     * @param dy    is the ball's dy velocity
     */
    public Ball(int x, int y, int r, java.awt.Color color, int dx, int dy) {
        this.center = new Point(x, y);
        this.size = r;
        this.color = color;
        this.velocity = new Velocity(dx, dy);
        this.game = new GameEnvironment();
        this.snowFlake = new SnowFlake((int) this.center.getX(), (int) this.center.getY(), SIZE_OF_PIXEL);
    }

    /**
     * @return the x value of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y value of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the size of the ball
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return the center point
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @return game environment
     */
    public GameEnvironment getGame() {
        return this.game;
    }

    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param v is the new velocity to set
     */
    public void setVelocity(Velocity v) {
        this.velocity.setDx(v.getDx());
        this.velocity.setDy(v.getDy());
    }

    /**
     * @param dx is the new dx velocity to set
     * @param dy is the new dy velocity to set
     */
    public void setVelocity(double dx, double dy) {
        this.velocity.setDx(dx);
        this.velocity.setDy(dy);
    }

    /**
     * @param centerP is the point to assign
     */
    public void setCenter(Point centerP) {
        this.center = centerP;
    }

    /**
     * @return velocity of the ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * The function draw the ball on the given DrawSurface.
     *
     * @param surface is a DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.LIGHT_GRAY);
        //surface.drawCircle((int) this.center.getX()+this.getSize()*2, (int) this.center.getY()+this.size*2,
        //this.size*3);
        this.snowFlake.drawOne(surface, (int) this.center.getX(), (int) this.center.getY());
    }

    /**
     * The function move the ball one step.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * The function update the center point in order to make a move and consider the window size, and collidable object.
     *
     * @param startX is the start x of the border
     * @param startY is the start y of the border
     * @param endX   is the end x of the border
     * @param endY   is the end y of the border
     */
    public void moveOneStep(int startX, int startY, int endX, int endY) {
        Point centerAfterV = this.velocity.applyToPoint(this.center);
        if ((centerAfterV.getX() <= startX + this.size && this.velocity.getDx() < 0)
                || (centerAfterV.getX() >= endX - this.size && this.velocity.getDx() > 0)) {
            this.velocity.setDx(CHANGE_VELOCITY * this.velocity.getDx());
        }
        if ((centerAfterV.getY() <= startY + this.size && this.velocity.getDy() < 0)
                || (centerAfterV.getY() >= endY - this.size && this.velocity.getDy() > 0)) {
            this.velocity.setDy(CHANGE_VELOCITY * this.velocity.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * the function update the center point in order to make a move.
     */
    public void moveOneStep() {
        for (int i = 0; i < OPTIONAL_COLLISION; i++) {
            Line trajectory = new Line(this.center,
                    this.getVelocity().applyToPoint(this.getVelocity().applyToPoint(this.center)));
            CollisionInfo collisionInfo = this.game.getClosestCollision(trajectory);
            if (collisionInfo == null) {
                break;
            } else {
                this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                        this.velocity);
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * The function add the ball to the game.
     *
     * @param g is the game to add to
     */
    public void addToGame(GameLevel g) {
        this.game = g.getEnvironment();
        g.addSprite(this);
    }

    /**
     * The function remove the ball from the game it received.
     *
     * @param g is the game to remove the ball
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * The function add a listener to the listeners list.
     *
     * @param hl is the listener to add
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * The function remove a listener from the listeners list.
     *
     * @param hl is the listener to remove
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The function notify all listeners that the block got hit.
     *
     * @param hitter is the ball how hit this block
     */
    public void notifyHit(Block hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(hitter, this);
        }
    }
}
