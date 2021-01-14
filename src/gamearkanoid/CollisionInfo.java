package gamearkanoid; /**
 * @author Amit Sharabi
 * 323784298
 */

import geometry.Point;
import interfaces.Collidable;

/**
 * This class represent information about a collision. This information includes the point of the collision and the
 * collidable object involved in the collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable object;

    /**
     * @param p is the point of the collision
     * @param c is the collidable
     */
    public CollisionInfo(Point p, Collidable c) {
        this.collisionPoint = new Point(p);
        this.object = c;
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}
