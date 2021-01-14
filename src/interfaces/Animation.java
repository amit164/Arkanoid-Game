package interfaces;

import biuoop.DrawSurface;

/**
 * This interface represent an Animation and support two functions: doOneFrame in which every animation should do, and
 * the function shouldStop that checks if the animation should stop.
 */
public interface Animation {
    /**
     * The function doing one frame for the animation.
     *
     * @param d is the draw surface to draw
     */
    void doOneFrame(DrawSurface d);

    /**
     * The function checks if the animation should stop.
     *
     * @return true if the animation should stop and false otherwise
     */
    boolean shouldStop();
}
