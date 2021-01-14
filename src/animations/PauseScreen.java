package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gamearkanoid.SpriteCollection;
import interfaces.Animation;

import java.awt.Color;

/**
 * This class represent the pause screen. This class show an pause message on the screen corresponded when the player
 * press on p to pause.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private SpriteCollection gameScreen;


    /**
     * Constructor function.
     *
     * @param gameScreen is the sprite collection on the game
     * @param k is the keyboard sensor
     */
    public PauseScreen(KeyboardSensor k, SpriteCollection gameScreen) {
        this.keyboard = k;
        this.gameScreen = gameScreen;
        this.stop = false;
    }

    /**
     * The function draw an animation for the pause screen.
     *
     * @param d is the draw surface to draw
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.drawText(d.getWidth() / 5, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
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
