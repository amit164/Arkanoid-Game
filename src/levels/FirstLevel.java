package levels;

import backgrounds.SnowMan;
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
 * This class represent the first level on the game. In this level there is only one block and one ball that go's
 * straightly to the block.
 */
public class FirstLevel implements LevelInformation {
    private static final int BALLS_AT_FIRST_LEVEL = 1;
    private static final int DX = 0;
    private static final int DY = 7;
    private static final int VELOCITY = 5;
    private static final int WIDTH = 100;
    private static final Point POS = new Point(325, 120);
    private static final Point SCREEN = new Point(0, 0);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int BLOCK_WIDTH = 160;
    private static final int BLOCK_HEIGHT = 70;
    private static final Point LOCATION = new Point(350, 550);

    /**
     * @return the number of balls in the first level
     */
    @Override
    public int numberOfBalls() {
        return BALLS_AT_FIRST_LEVEL;
    }

    /**
     * @return new List of the balls velocity
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(DX, DY));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        //return new Block(new Rectangle(SCREEN, SCREEN_WIDTH, SCREEN_HEIGHT), Color.lightGray, false);
        return new SnowMan();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(POS, BLOCK_WIDTH, BLOCK_HEIGHT), new Color(197, 216, 255), true));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return BALLS_AT_FIRST_LEVEL;
    }

    /**
     * @return location of the paddle
     */
    public Point locationOfPaddle() {
        return LOCATION;
    }
}
