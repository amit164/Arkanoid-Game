package graphics;

import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent snow flake and show it on screen.
 */
public class SnowFlake implements Sprite {
    private int xPos;
    private int yPos;
    private int sizeOfPixel;

    /**
     * Constructor function.
     *
     * @param xPos        is the x position the snow flake
     * @param yPos        is the x position the snow flake
     * @param sizeOfPixel is the pixel's size
     */
    public SnowFlake(int xPos, int yPos, int sizeOfPixel) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeOfPixel = sizeOfPixel;
    }

    /**
     * This function draw one snow flake.
     *
     * @param d is the draw surface to draw on
     * @param x is the x place to draw
     * @param y is the y place to draw
     */
    public void drawOne(DrawSurface d, int x, int y) {
        d.setColor(new Color(135, 227, 250));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (pixelsToDraw(i + 1).contains(j + 1)) {
                    d.setColor(Color.WHITE);
                    d.fillRectangle(x + j * this.sizeOfPixel, y + this.sizeOfPixel * i, this.sizeOfPixel,
                            this.sizeOfPixel);
                }
            }
        }
    }

    /**
     * @param i is the line
     * @return a list of all places that should draw a pixel
     */
    private static List<Integer> pixelsToDraw(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 1:
            case 13:
                lst.add(7);
                return lst;
            case 2:
            case 12:
                lst.add(4);
                lst.add(6);
                lst.add(7);
                lst.add(8);
                lst.add(10);
                return lst;
            case 3:
            case 11:
                lst.add(3);
                lst.add(7);
                lst.add(11);
                return lst;
            case 4:
            case 10:
                lst.add(2);
                lst.add(4);
                lst.add(7);
                lst.add(12);
                lst.add(10);
                return lst;
            case 5:
            case 9:
                lst.add(5);
                lst.add(7);
                lst.add(9);
                return lst;
            case 6:
            case 8:
                lst.add(2);
                lst.add(6);
                lst.add(7);
                lst.add(8);
                lst.add(12);
                return lst;
            default:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(5);
                lst.add(6);
                lst.add(7);
                lst.add(8);
                lst.add(9);
                lst.add(10);
                lst.add(11);
                lst.add(12);
                lst.add(13);
                return lst;
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawOne(d, this.xPos, this.yPos);
    }

    @Override
    public void timePassed() {

    }

    /**
     * @return the center point of the flake
     */
    public Point getCenter() {
        return new Point(this.xPos, this.yPos);
    }

    /**
     * The function set a new center point for the snow flake.
     *
     * @param p is the point to assign
     */
    public void setPoint(Point p) {
        this.xPos = (int) p.getX();
        this.yPos = (int) p.getY();
    }

    /**
     * @param yPos1 is the new yPos to assign
     */
    public void setyPos(int yPos1) {
        this.yPos = yPos1;
    }
}
//for example:
//Snowflake.drawOne(d, 400, 400);

