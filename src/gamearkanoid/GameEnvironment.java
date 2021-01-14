package gamearkanoid;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Sharabi
 * 323784298
 */

/**
 * This class represent the game enviroment. The GameArkanoid.GameEnvironment class is a collection of objects a
 * GameObjects. Ball can collide with.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor function. The function create new collidable list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * The function add the given collidable to the environment.
     *
     * @param c is a collidable to add
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * The function delete a collidable from the list.
     *
     * @param c is the collidable object to remove.
     */
    public void deleteCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * the function assume that an object moving from line.start() to line.end(). The function go throw all
     * collidables object in the game and checks if this object will collide with any of them. if there is object to
     * collied with, returns the information about the closest collision that is going to occur, and null otherwise.
     *
     * @param trajectory is the trajectory of the moving object
     * @return if there is object to collied with, returns the information about the closest collision that is going
     * to occur, and null otherwise.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle rect = null;
        Collidable objectCollision = null;
        Point collision = null;
        Point temp = null;
        for (Collidable c : this.collidables) {
            rect = c.getCollisionRectangle();
            temp = trajectory.closestIntersectionToStartOfLine(rect);
            if (temp != null) {
                if (collision == null) {
                    collision = new Point(temp);
                    objectCollision = c;
                } else {
                    if (trajectory.start().distance(collision) > trajectory.start().distance(temp)) {
                        collision = new Point(temp);
                        objectCollision = c;
                    }
                }
            }
        }
        if (collision == null) {
            return null;
        }
        return new CollisionInfo(collision, objectCollision);
    }
}

