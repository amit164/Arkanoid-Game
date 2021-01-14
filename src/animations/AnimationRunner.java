package animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/**
 * This class represent the animation runner which run every animation.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    //screen
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * Constructor function.
     */
    public AnimationRunner() {
        this.gui = new GUI("arkanoid", WIDTH, HEIGHT);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * The function runs the animation.
     *
     * @param animation is the animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
