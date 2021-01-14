package gameobject;

import gamearkanoid.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import graphics.SnowBlock;
import interfaces.Collidable;
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
 * This class represent a block object. A block is a collidable and a sprite object that can be on ta game.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    private SnowBlock snowBlock;
    private boolean snow;

    private static final double EP = Math.pow(10, -10);
    private static final int CHANGE_VELOCITY = -1;

    /**
     * constuctor function, create a new block with rectangle and color.
     *
     * @param rect is a rectangle
     * @param c    is the color of the block
     * @param snow is true if should appear snow on the block and false otherwise.
     */
    public Block(Rectangle rect, Color c, boolean snow) {
        this.rectangle = new Rectangle(rect);
        this.color = c;
        this.hitListeners = new ArrayList<>();
        this.snowBlock = new SnowBlock((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight(), this.color);
        this.snow = snow;
    }

    /**
     * the function return the "collision shape" of the object.
     *
     * @return the rectangle of the block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the listeners that we collided with it at collisionPoint with a given velocity. The function checks where
     * the collidion happend on the rectangle and return the new velocity expected after the hit (based on the force
     * the object inflicted on us).
     *
     * @param hitter          is the ball that we got hit with
     * @param collisionPoint  is the collisn point of the object
     * @param currentVelocity is the velocity of the object the colliede with.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //check where is the collisionPoint and change the velocity accordingly
        if (Math.abs(this.rectangle.getUpperLeft().getY() - collisionPoint.getY()) <= EP
                || Math.abs(this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight()
                - collisionPoint.getY()) <= EP) {
            dy = CHANGE_VELOCITY * dy;
        }
        if (Math.abs(this.rectangle.getUpperLeft().getX() - collisionPoint.getX()) <= EP
                || Math.abs(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()
                - collisionPoint.getX()) <= EP) {
            dx = CHANGE_VELOCITY * dx;
        }
        this.notifyHit(hitter);
        if (collisionPoint.getY() >= GameLevel.DOWN_BOUND - EP) {
            hitter.notifyHit(this);
        }
        return new Velocity(dx, dy);
    }

    /**
     * The function draw the block on the given DrawSurface.
     *
     * @param surface is a DrawSurface to draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        if (this.snow) {
            this.snowBlock.drawOn(surface);
        }
    }

    /**
     *
     */
    @Override
    public void timePassed() {
    }

    /**
     * The function add the block to the game.
     *
     * @param g is the game to add to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * The function remove the block from the game it received.
     *
     * @param game is the game to remove the block
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
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
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
