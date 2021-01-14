package interfaces;

import gameobject.Ball;
import gameobject.Block;

/**
 * This interface represent any Listener to hit action.It requires the hit listeners to act when there is a hit.
 */
public interface HitListener {
    /**
     * The function is called whenever the beingHit object is hit.
     *
     * @param beingHit is the object that got hit.
     * @param hitter   is the GameObjects.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
