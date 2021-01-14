package listeners;

import gamearkanoid.Counter;
import gamearkanoid.GameLevel;
import gameobject.Ball;
import gameobject.Block;
import interfaces.HitListener;

/**
 * This class represent a GameObjects.Block Remover object. Its a listener that listen to every block and remove it
 * if got hit the by a ball.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    private static final int ONE_GOT_HIT = 1;

    /**
     * Constructor function.
     *
     * @param game          is the game that played.
     * @param removedBlocks is the number of blocks that removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * The function remove this listener from the block that got hit and remove the block that got hit from the game.
     *
     * @param beingHit is the object that got hit.
     * @param hitter   is the GameObjects.Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(ONE_GOT_HIT);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
    }
}
