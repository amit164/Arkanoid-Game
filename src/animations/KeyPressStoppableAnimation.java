package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * This class represent the key pressed check.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean isPressed;
    private Animation animation;
    private String key;
    private boolean stop;

    /**
     * @param sensor    is the keyboard sensor
     * @param key       is the key to check if pressed
     * @param animation is the animation to run
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.isPressed = true;
        this.key = key;
        this.animation = animation;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.isPressed && this.keyboard.isPressed(this.key)) {
            this.stop = true;
        }
        if (!this.keyboard.isPressed(this.key)) {
            this.isPressed = false;
        }
        this.animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
