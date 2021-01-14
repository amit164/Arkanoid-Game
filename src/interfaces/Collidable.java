package interfaces; /**
 * @author Amit Sharabi
 * 323784298
 */


import gameobject.Ball;
import gameobject.Velocity;
import geometry.Point;
import geometry.Rectangle;

/**
 * The Intefaces.Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity. The function return the
     * new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          is the ball that we hit
     * @param collisionPoint  is the collisn point of the object
     * @param currentVelocity is the velocity of the object the colliede with.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
