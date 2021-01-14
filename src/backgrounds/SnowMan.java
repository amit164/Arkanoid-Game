package backgrounds;

import biuoop.DrawSurface;
import gameobject.Ball;
import gameobject.Block;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Sprite;

import java.awt.Color;

/**
 * This class represent the Snow man background.
 */
public class SnowMan implements Sprite {
    private static final Point SCREEN = new Point(0, 0);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    //body
    private static final int HEAD_RADIUS = 30;
    private static final Point HEAD_CENTER = new Point(400, 150);
    private static final int BODY1_RADIUS = 50;
    private static final int BODY2_RADIUS = 75;
    //details
    private static final int EYE_RADIUS = 5;
    private static final int SMILE_RADIUS = 2;
    private static final int SPACE_FOR_SMILE = 3;

    @Override
    public void drawOn(DrawSurface d) {
        (new Block(new Rectangle(SCREEN, SCREEN_WIDTH, SCREEN_HEIGHT), new Color(229, 238, 255), false)).drawOn(d);
        //draw the snow man's body
        Ball head = new Ball(HEAD_CENTER, HEAD_RADIUS, Color.WHITE);
        d.setColor(head.getColor());
        d.fillCircle(head.getX(), head.getY() + head.getSize() + 120, BODY2_RADIUS);
        d.setColor(Color.BLACK);
        d.drawCircle(head.getX(), head.getY() + head.getSize() + 120, BODY2_RADIUS);
        d.setColor(head.getColor());
        d.fillCircle(head.getX(), head.getY() + head.getSize() + 30, BODY1_RADIUS);
        d.setColor(Color.BLACK);
        d.drawCircle(head.getX(), head.getY() + head.getSize() + 30, BODY1_RADIUS);
        d.setColor(head.getColor());
        d.fillCircle(head.getX(), head.getY(), head.getSize());
        d.setColor(Color.BLACK);
        d.drawCircle(head.getX(), head.getY(), head.getSize());
        //draw details
        d.fillCircle(head.getX() - 10, head.getY() - 7, EYE_RADIUS);
        d.fillCircle(head.getX() + 10, head.getY() - 7, EYE_RADIUS);
        d.setColor(Color.ORANGE);
        d.drawLine(head.getX() - 13, head.getY() + 13, head.getX(), head.getY() + 5);
        d.drawLine(head.getX() - 13, head.getY() + 14, head.getX(), head.getY() + 6);
        d.drawLine(head.getX() - 13, head.getY() + 15, head.getX(), head.getY() + 7);
        d.setColor(Color.BLACK);
        for (int i = 0; i < 2; i++) {
            d.fillCircle(head.getX() - 20 + 2 * i * SPACE_FOR_SMILE, head.getY() + 10 + 2 * i * SPACE_FOR_SMILE,
                    SMILE_RADIUS);
        }
        d.fillCircle(head.getX() - 20 + 4 * SPACE_FOR_SMILE, head.getY() + 10 + 3 * SPACE_FOR_SMILE,
                SMILE_RADIUS);
        d.fillCircle(head.getX() - 20 + 7 * SPACE_FOR_SMILE, head.getY() + 10 + 3 * SPACE_FOR_SMILE,
                SMILE_RADIUS);
        for (int i = 0; i < 2; i++) {
            d.fillCircle(head.getX() + 15 - 2 * i * SPACE_FOR_SMILE, head.getY() + 10 + 2 * i * SPACE_FOR_SMILE,
                    SMILE_RADIUS);
        }
    }

    @Override
    public void timePassed() {
    }
}
