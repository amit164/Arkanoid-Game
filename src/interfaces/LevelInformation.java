package interfaces;

import gameobject.Block;
import gameobject.Velocity;
import geometry.Point;

import java.util.List;

/**
 * This interface represent level information and include all the information that a level should have.
 */
public interface LevelInformation {

    /**
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * @return the initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * @return a string of the level name that we want to display at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return a block list that make up this level.
     */
    List<Block> blocks();

    /**
     * @return the number of blocks that should be removed before the level is considered to be "cleared"
     */
    int numberOfBlocksToRemove();

    /**
     * @return the location of the paddle
     */
    Point locationOfPaddle();
}
