package levels;

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
 * This class represent the fourth level on the game. In this level there is 6 lines of blocks and two balls.
 */
public class FourthLevel implements LevelInformation {
    private static final int BALLS_AT_FOURTH_LEVEL = 3;
    private static final int VELOCITY = 7;
    private static final int SPEED = 7;
    private static final int ANGLE_ZERO = 0;
    private static final int ANGLE_30 = 30;
    private static final int ANGLE_330 = 330;
    private static final int WIDTH = 150;
    private static final Point SCREEN = new Point(0, 0);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final double BLOCK_WIDTH = 48;
    private static final int BLOCK_HEIGHT = 30;
    private static final int NUMBER_OF_BLOCKS = 96;
    private static final Point LOCATION = new Point(325, 550);

    //Blocks.
    private static final int NUMBER_OF_ROWS = 6;
    private static final int BLOCKS_IN_ROW = 16;
    private static final int BLOCK_X_START = 20;
    private static final int BLOCK_Y_START = 100;

    /**
     * @return the number of balls in the first level
     */
    @Override
    public int numberOfBalls() {
        return BALLS_AT_FOURTH_LEVEL;
    }

    /**
     * @return new List of the balls velocity
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(ANGLE_30, SPEED));
        list.add(Velocity.fromAngleAndSpeed(ANGLE_ZERO, SPEED));
        list.add(Velocity.fromAngleAndSpeed(ANGLE_330, SPEED));
        return list;
    }

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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(SCREEN, SCREEN_WIDTH, SCREEN_HEIGHT), new Color(200, 225, 255), false);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < BLOCKS_IN_ROW; j++) {
                blocks.add(new Block(new Rectangle(new Point(BLOCK_X_START + BLOCK_WIDTH * j,
                        BLOCK_Y_START + BLOCK_HEIGHT * i), BLOCK_WIDTH, BLOCK_HEIGHT), new Color(160 - 10 * j,
                        105 + 10 * j - 10 * i, 237), true));
            }
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
