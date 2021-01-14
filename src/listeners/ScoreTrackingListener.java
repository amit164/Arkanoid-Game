package listeners;

import gamearkanoid.Counter;
import gameobject.Ball;
import gameobject.Block;
import interfaces.HitListener;

/**
 * This class represent Score Tracking object that tracks the score at the game and change it according to the hits.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    private static final int POINTS_FOR_ONE_BLOCK = 5;

    /**
     * Constructor function.
     *
     * @param scoreCounter is the score to start with.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * The function add points to the score after hit of a block.
     *
     * @param beingHit is the object that got hit.
     * @param hitter   is the GameObjects.Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(POINTS_FOR_ONE_BLOCK);
    }
}
