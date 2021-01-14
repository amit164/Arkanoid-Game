package gamearkanoid;

import animations.AnimationRunner;
import animations.CountdownAnimation;
import animations.KeyPressStoppableAnimation;
import animations.PauseScreen;
import biuoop.KeyboardSensor;
import gameobject.Ball;
import gameobject.Block;
import gameobject.Paddle;
import gameobject.Velocity;
import geometry.Point;
import geometry.Rectangle;
import graphics.Icicles;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreIndicator;
import listeners.ScoreTrackingListener;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * @author Amit Sharabi
 * 323784298
 */

/**
 * This class represent the game. The GameArkanoid.Game class holds the sprites and the collidables in the game, in
 * charge of the animation.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blocks;
    private Counter balls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    public static int x;


    //balls
    private static final int X_LOCATION_OF_BALLS = 400;
    private static final int Y_LOCATION_OF_BALLS = 540;
    private static final int ADD_BALL = 1;
    private static final int NO_BALLS_LEFT = 0;
    //screen
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    //border blocks
    private static final int START_OF_BLOCK1 = 0;
    private static final int START_OF_BLOCK1_Y = 0;
    private static final int START_OF_BLOCK2_X = 20;
    private static final int START_OF_BLOCK3_X = 780;
    private static final int START_OF_BLOCK4_X = -10;
    private static final int WIDTH_AND_HRIGHT_OF_BORDER1 = 20;
    private static final int WIDTH_AND_HRIGHT_OF_Y = 600;
    private static final int WIDTH_AND_HRIGHT_OF_X = 800;
    //blocks
    private static final int HEIGHT_OF_BLOCKS = 20;
    private static final int NO_BLOCKS_LEFT = 0;
    public static final int DOWN_BOUND = 601;
    private static final int WIDTH_DOWN_BLOCK = 900;
    //score
    private static final int SCORE_FOR_ALL_BLOCKS_HIT = 100;
    //countdown
    private static final int COUNT_FROM_AND_FOR = 3;


    /**
     * constructor function. The function create a game level.
     *
     * @param levelInformation is the level
     * @param keyboard         is a keyboard sensor
     * @param animationRunner  is the animation runner
     * @param score            is the score that the level start with
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner animationRunner,
                     int score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blocks = new Counter();
        this.balls = new Counter();
        this.score = new Counter();
        this.score.increase(score);
        this.runner = animationRunner;
        this.running = true;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
    }

    /**
     * The function add new collidable to the game.
     *
     * @param c is the collidable to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The function add new sprite to the game.
     *
     * @param s is the sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * @return the ball counter.
     */
    public Counter getBalls() {
        return balls;
    }

    /**
     * The function removes a collidable from the game.
     *
     * @param c is the collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        getEnvironment().deleteCollidable(c);
    }

    /**
     * The function removes a sprinte from the game.
     *
     * @param s is the sprite object to remove.
     */
    public void removeSprite(Sprite s) {
        getSprites().deleteSprite(s);
    }

    /**
     * The function initialize a new game: create the Blocks and GameObjects.Ball (and GameObjects.Paddle) and add
     * them to the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInformation.getBackground());
        if (this.levelInformation.levelName().equals("Final Four")) {
            this.sprites.addSprite(new Icicles());
        }
        //creating the removers
        BlockRemover blockRemover = new BlockRemover(this, getBlocks());
        BallRemover ballRemover = new BallRemover(this, getBalls());
        //score tracking
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(getScore());
        ScoreIndicator scoreIndicator = new ScoreIndicator(getScore(), this.levelInformation.levelName());
        //creating all the balls
        int numberOfBalss = this.levelInformation.numberOfBalls();
        List<Velocity> velocityList = this.levelInformation.initialBallVelocities();
        for (int i = 0; i < numberOfBalss; i++) {
            Ball ball = new Ball(new Point(X_LOCATION_OF_BALLS, Y_LOCATION_OF_BALLS), 3, Color.RED);
            ball.setVelocity(velocityList.get(i).getDx(), velocityList.get(i).getDy());
            ball.addToGame(this);
            ball.addHitListener(ballRemover);
            this.balls.increase(ADD_BALL);
        }
        //the paddle
        Paddle paddle = new Paddle(this.runner.getGui().getKeyboardSensor(), this.levelInformation.paddleWidth(),
                this.levelInformation.paddleSpeed(), this.levelInformation.locationOfPaddle());
        paddle.addToGame(this);
        //creating the blocks at the game
        List<Block> blocksList = this.levelInformation.blocks();
        this.blocks.increase(this.levelInformation.numberOfBlocksToRemove());
        for (Block block : blocksList) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
        //creating boundary block
        Block b7 = new Block(new Rectangle(new Point(START_OF_BLOCK1, START_OF_BLOCK1_Y), WIDTH_AND_HRIGHT_OF_BORDER1,
                WIDTH_AND_HRIGHT_OF_Y), Color.GRAY, false);
        Block b8 = new Block(new Rectangle(new Point(START_OF_BLOCK1, START_OF_BLOCK1_Y), WIDTH_AND_HRIGHT_OF_X,
                WIDTH_AND_HRIGHT_OF_BORDER1), Color.GRAY, false);
        Block b9 = new Block(new Rectangle(new Point(START_OF_BLOCK3_X, START_OF_BLOCK2_X), WIDTH_AND_HRIGHT_OF_BORDER1,
                WIDTH_AND_HRIGHT_OF_Y), Color.GRAY, false);
        Block downBound = new Block(new Rectangle(new Point(START_OF_BLOCK4_X, DOWN_BOUND), WIDTH_DOWN_BLOCK,
                HEIGHT_OF_BLOCKS), Color.GRAY, false);
        b7.addToGame(this);
        b8.addToGame(this);
        b9.addToGame(this);
        downBound.addToGame(this);
        //add the score as the last sprite so it can be showed
        getSprites().addSprite(scoreIndicator);
    }

    /**
     * The function run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(COUNT_FROM_AND_FOR, COUNT_FROM_AND_FOR, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * @return the game environment
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * @return the sprite collection
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * @return the block counter
     */
    public Counter getBlocks() {
        return blocks;
    }

    /**
     * @return the score.
     */
    public Counter getScore() {
        return score;
    }


    /**
     * The function do a frame for the game - draw all objects and update the score.
     *
     * @param d is the draw surface to draw
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        //for pause screen
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("P") || this.keyboard.isPressed("פ")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new
                    PauseScreen(this.keyboard, this.sprites)));
        }
        //hit all balls
        if (this.blocks.getValue() == NO_BLOCKS_LEFT) {
            this.score.increase(SCORE_FOR_ALL_BLOCKS_HIT);
            this.running = false;
        }
        //all balls fell
        if (this.balls.getValue() == NO_BALLS_LEFT) {
            this.running = false;
        }
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
    }

    /**
     * The function return if the animation should stop.
     *
     * @return true if the animation should stop and false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}