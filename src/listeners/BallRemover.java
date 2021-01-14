package listeners;

import gamearkanoid.Counter;
import gamearkanoid.GameLevel;
import gameobject.Ball;
import gameobject.Block;
import interfaces.HitListener;

/**
 * This class represent a GameObjects.Ball Remover object. Its a listener that listen to every ball and remove it if
 * its hit the down boundary.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    private static final int ONE_GOT_HIT = 1;

    /**
     * Constructor function.
     *
     * @param game          is the game that played.
     * @param removedBlocks is the number of blocks that removed.
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }

    /**
     * The function remove this listener from the block that got hit and remove the block that got hit from the game.
     *
     * @param beingHit is the object that got hit.
     * @param hitter   is the GameObjects.Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(ONE_GOT_HIT);
        hitter.removeHitListener(this);
        hitter.removeFromGame(this.game);
    }
}
