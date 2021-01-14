package backgrounds;

import biuoop.DrawSurface;
import gameobject.Block;
import gameobject.Velocity;
import geometry.Point;
import geometry.Rectangle;
import gameobject.Ball;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the falling snow balls background.
 */
public class FallingSnowBalls implements Sprite {
    private List<gameobject.Ball> ballList;
    private List<Velocity> velocities;

    private static final Point SCREEN = new Point(0, 0);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int NUMBER_OF_BALLS = 9;
    private static final int RADIUS = 7;

    /**
     * Constructor function.
     */
    public FallingSnowBalls() {
        this.ballList = new ArrayList<>();
        this.velocities = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            this.ballList.add(new Ball(90 * i, -30 - 10 * i, RADIUS, Color.WHITE));
        }
        for (int i = 0; i < this.ballList.size(); i++) {
            if (i % 2 == 0) {
                this.velocities.add(new Velocity(0, 1 + 0.1 * i));
            } else {
                this.velocities.add(new Velocity(0, 1 + 0.2 * i));
            }
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        (new Block(new Rectangle(SCREEN, SCREEN_WIDTH, SCREEN_HEIGHT), new Color(200, 225, 255), false)).drawOn(d);
        for (Ball ball : this.ballList) {
            d.setColor(Color.WHITE);
            d.fillCircle(ball.getX(), ball.getY(), RADIUS);
            d.setColor(Color.lightGray);
            d.drawCircle(ball.getX(), ball.getY(), RADIUS);
        }
    }

    @Override
    public void timePassed() {
        for (int i = 0; i < this.ballList.size(); i++) {
            if (this.ballList.get(i).getY() >= SCREEN_HEIGHT + RADIUS) {
                this.ballList.get(i).setCenter(new Point(0, -RADIUS));
            } else {
                this.ballList.get(i).setCenter(this.velocities.get(i).applyToPoint(this.ballList.get(i).getCenter()));
            }
        }
    }
}
