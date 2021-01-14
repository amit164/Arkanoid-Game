package interfaces; /**
 * @author Amit Sharabi
 * 323784298
 */

import biuoop.DrawSurface;

/**
 * Intefaces. Sprite is a game object that can be drawn to the screen. Sprites can be drawn on the screen, and can be
 * notified that time has passed
 */
public interface Sprite {
    /**
     * The function draw the sprite to the screen.
     *
     * @param d is the draw surface to draw on
     */
    void drawOn(DrawSurface d);

    /**
     * The function notify the sprite that time has passed.
     */
    void timePassed();
}