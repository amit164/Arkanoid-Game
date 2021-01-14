package levels;

import backgrounds.FallingSnow;
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
 * This class represent the third level on the game. In this level there is 6 lines of blocks and 2 balls that
 * moves to different places.
 */
public class ThirdLevel implements LevelInformation {
    private static final int BALLS_AT_THIRD_LEVEL = 2;
    private static final int DX = 3;
    private static final int DY = 5;
    private static final int VELOCITY = 7;
    private static final int WIDTH = 150;
    private static final int BLOCK_WIDTH = 48;
    private static final int BLOCK_HEIGHT = 30;
    private static final int NUMBER_OF_BLOCKS = 63;
    private static final Point LOCATION = new Point(325, 550);

    //Blocks.
    private static final int NUMBER_OF_ROWS = 6;
    private static final int BLOCKS_IN_ROW = 13;
    private static final int BLOCK_X_START = 160;
    private static final int BLOCK_Y_START = 120;

    /**
     * @return the number of balls in the first level
     */
    @Override
    public int numberOfBalls() {
        return BALLS_AT_THIRD_LEVEL;
    }

    /**
     * @return new List of the balls velocity
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(DX, DY));
        list.add(new Velocity(-DX, -DY));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new FallingSnow();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = i; j < BLOCKS_IN_ROW; j++) {
                blocks.add(new Block(new Rectangle(new Point(BLOCK_X_START + BLOCK_WIDTH * j,
                        BLOCK_Y_START + BLOCK_HEIGHT * i), BLOCK_WIDTH, BLOCK_HEIGHT), new Color(150 - 10 * j,
                        100 + 10 * j - 10 * i, 237), true));
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
