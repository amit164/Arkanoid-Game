package listeners;

import gamearkanoid.Counter;
import interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class represent a Score Indicator object that show the score on the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private String levelName;

    private static final int X_LOCATION = 380;
    private static final int X_LOCATION_NAME = 600;
    private static final int Y_LOCATION = 15;

    /**
     * Constructor function.
     *
     * @param score is the score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * Constructor function.
     *
     * @param levelName is the level's name
     * @param score     is the score.
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
    }

    /**
     * The function drwa the score.
     *
     * @param d is the draw surface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(X_LOCATION, Y_LOCATION, "Score: " + this.score.getValue(), 12);
        d.drawText(X_LOCATION_NAME, Y_LOCATION, "Level Name: " + this.levelName, 12);
    }

    @Override
    public void timePassed() {
    }
}
