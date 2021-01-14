package animations;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import gamearkanoid.SpriteCollection;
import interfaces.Animation;

import java.awt.Color;

/**
 * This class represent the count down animation. This class can count down from evey number and show it on screen.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int timeLeft;
    private boolean firstFrame;


    /**
     * Constructor function.
     *
     * @param numOfSeconds is the number of seconds that the animation should appear.
     * @param countFrom    is the start of countdown.
     * @param gameScreen   is the screen of the game
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timeLeft = countFrom;
        this.firstFrame = true;
    }

    /**
     * The function do one frame of the countdown.
     *
     * @param d is the draw surface to draw
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.GRAY);
        d.drawText(d.getWidth() / 2 - 60, d.getHeight() / 2, "" + this.timeLeft, 200);
        this.timeLeft--;
        if (this.firstFrame) {
            this.firstFrame = false;
            return;
        }
        sleeper.sleepFor((long) (1000 * (this.numOfSeconds / this.countFrom)));
    }

    /**
     * @return if the animation should stop
     */
    @Override
    public boolean shouldStop() {
        return (this.timeLeft < 0);
    }
}
