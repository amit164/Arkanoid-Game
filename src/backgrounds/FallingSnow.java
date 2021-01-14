package backgrounds;

import biuoop.DrawSurface;
import gameobject.Block;
import gameobject.Velocity;
import geometry.Point;
import geometry.Rectangle;
import graphics.SnowFlake;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the Falling snow background.
 */
public class FallingSnow implements Sprite {
    private List<SnowFlake> snowFlakeList;
    private List<Velocity> velocities;

    private static final Point SCREEN = new Point(0, 0);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int NUMBER_OF_SNOWFLAKES = 16;
    private static final int SIZE_OF_PIXEL = 4;

    /**
     * Constructor function.
     */
    public FallingSnow() {
        this.snowFlakeList = new ArrayList<>();
        this.velocities = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_SNOWFLAKES / 2; i++) {
            this.snowFlakeList.add(new SnowFlake(100 * i, -30 - 10 * i, SIZE_OF_PIXEL));
        }
        for (int i = 0; i < NUMBER_OF_SNOWFLAKES / 2; i++) {
            this.snowFlakeList.add(new SnowFlake(100 * i, SCREEN_HEIGHT / 2 - 20 * i, SIZE_OF_PIXEL));
        }
        for (int i = 0; i < this.snowFlakeList.size(); i++) {
            if (i % 2 == 0) {
                this.velocities.add(new Velocity(0, 1));
            } else {
                this.velocities.add(new Velocity(0, 1.5));
            }
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        (new Block(new Rectangle(SCREEN, SCREEN_WIDTH, SCREEN_HEIGHT), new Color(200, 225, 255), false)).drawOn(d);
        for (SnowFlake snowFlake : this.snowFlakeList) {
            snowFlake.drawOn(d);
        }
    }

    @Override
    public void timePassed() {
        for (int i = 0; i < this.snowFlakeList.size(); i++) {
            if (this.snowFlakeList.get(i).getCenter().getY() >= SCREEN_HEIGHT + SIZE_OF_PIXEL) {
                this.snowFlakeList.get(i).setyPos(-SIZE_OF_PIXEL);
            } else {
                Point p = this.velocities.get(i).applyToPoint(this.snowFlakeList.get(i).getCenter());
                this.snowFlakeList.get(i).setPoint(p);
            }
        }
    }
}
