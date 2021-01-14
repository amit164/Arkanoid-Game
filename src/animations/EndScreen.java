package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

import java.awt.Color;

/**
 * This class represent the end screen. When the games end this class show an end message on the screen corresponded
 * to the case that the game end in.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean win;
    private int score;
    private AnimationRunner runner;

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;

    /**
     * Constructor function.
     *
     * @param k      is the keyboard sensor
     * @param win    is ture if the player win and false otherwise
     * @param score  is the score the player end with
     * @param runner is the animation runner
     */
    public EndScreen(KeyboardSensor k, boolean win, int score, AnimationRunner runner) {
        this.keyboard = k;
        this.stop = false;
        this.win = win;
        this.score = score;
        this.runner = runner;
    }

    /**
     * The function draw an animation for the end screen.
     *
     * @param d is the draw surface to draw
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(229, 238, 255));
        d.fillRectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        d.setColor(Color.BLACK);
        if (this.win) {
            d.drawText(d.getWidth() / 5, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
        } else {
            d.drawText(d.getWidth() / 5, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.runner.getGui().close();
            this.stop = true;
        }
    }

    /**
     * The function return if the animation should stop.
     *
     * @return if the player don't want to pause anymore
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

