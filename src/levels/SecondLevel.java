package levels;

import backgrounds.FallingSnowBalls;
import gameobject.Block;
import gameobject.Velocity;
import geometry.Point;
import geometry.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the second level on the game. In this level there is one line of blocks and 10 balls that
 * moves to different places.
 */
public class SecondLevel implements LevelInformation {
    private static final int BALLS_AT_SECOND_LEVEL = 10;
    private static final int SPEED = 5;
    private static final int ANGLE = 0;
    private static final int VELOCITY = 5;
    private static final int WIDTH = 670;
    private static final int X_POS_FOR_BLOCK = 20;
    private static final int Y_POS_FOR_BLOCK = 200;
    private static final int BLOCK_WIDTH = 64;
    private static final int BLOCK_HEIGHT = 30;
    private static final int NUMBER_OF_BLOCKS = 12;
    private static final Point LOCATION = new Point(75, 550);

    /**
     * @return the number of balls in the first level
     */
    @Override
    public int numberOfBalls() {
        return BALLS_AT_SECOND_LEVEL;
    }

    /**
     * @return new List of the balls velocity
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 1; i <= BALLS_AT_SECOND_LEVEL / 2; i++) {
            list.add(Velocity.fromAngleAndSpeed(ANGLE + i * 15, SPEED));
        }
        for (int i = 1; i <= BALLS_AT_SECOND_LEVEL / 2; i++) {
            list.add(Velocity.fromAngleAndSpeed(ANGLE + i * -15, SPEED));
        }
        return list;
    }

    /**
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return VELOCITY;
    }

    @Override
    public int paddleWidth() {
        return WIDTH;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new FallingSnowBalls();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            blocks.add(new Block(new Rectangle(new Point(X_POS_FOR_BLOCK + i * BLOCK_WIDTH, Y_POS_FOR_BLOCK),
                    BLOCK_WIDTH, BLOCK_HEIGHT), new Color(188, 220, 246), true));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS;
    }

    /**
     * @return location of the paddle
     */
    public Point locationOfPaddle() {
        return LOCATION;
    }
}
