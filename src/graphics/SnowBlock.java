package graphics;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represent a Snow block - a block that on it there is snow.
 */
public class SnowBlock implements Sprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int numOfPixels = 16;
    private int sizeOfPixelWidth;
    private int sizeOfPixelHeight;
    private int type;

    /**
     * Constructor function.
     *
     * @param x      is the x place
     * @param y      is the y place
     * @param width  is the width of the block
     * @param height is the height of the block
     * @param color  is the color of the snow
     */
    public SnowBlock(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.color = color;
        this.height = height;
        this.width = width;
        this.y = y;
        this.sizeOfPixelWidth = width / numOfPixels;
        sizeOfPixelHeight = height / numOfPixels;
        Random random = new Random();
        this.type = random.nextInt(5) + 1;
    }


    /**
     * This function add blank pixels to the line i.
     *
     * @param i is the line
     * @return return a list of all the places in this line to put a blank pixel
     */
    public List<Integer> blankPixelsInLine1(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 6:
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            case 7:
                lst.add(4);
                lst.add(5);
                lst.add(6);
                lst.add(7);
                lst.add(8);
                lst.add(14);
                lst.add(15);
                lst.add(13);
                lst.add(16);
                return lst;
            case 8:
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
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            default:
                return null;
        }
    }

    /**
     * This function add blank pixels to the line i.
     *
     * @param i is the line
     * @return return a list of all the places in this line to put a blank pixel
     */
    public List<Integer> blankPixelsInLine2(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 6:
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            case 7:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(14);
                lst.add(15);
                lst.add(13);
                lst.add(16);
                return lst;
            case 8:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(8);
                lst.add(9);
                lst.add(10);
                lst.add(12);
                lst.add(13);
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            default:
                return null;
        }
    }

    /**
     * This function add blank pixels to the line i.
     *
     * @param i is the line
     * @return return a list of all the places in this line to put a blank pixel
     */
    public List<Integer> blankPixelsInLine3(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 4:
                lst.add(3);
                return lst;
            case 5:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(11);
                lst.add(12);
                return lst;
            case 6:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(5);
                lst.add(9);
                lst.add(10);
                lst.add(11);
                lst.add(12);
                lst.add(13);
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            case 7:
            case 8:
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
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            default:
                return null;
        }
    }

    /**
     * This function add blank pixels to the line i.
     *
     * @param i is the line
     * @return return a list of all the places in this line to put a blank pixel
     */
    public List<Integer> blankPixelsInLine4(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 5:
                lst.add(2);
                lst.add(3);
                lst.add(4);
                return lst;
            case 6:
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
                return lst;
            case 7:
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
                lst.add(16);
                return lst;
            case 8:
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
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            default:
                return null;
        }
    }

    /**
     * This function add blank pixels to the line i.
     *
     * @param i is the line
     * @return return a list of all the places in this line to put a blank pixel
     */
    public List<Integer> blankPixelsInLine5(int i) {
        List<Integer> lst = new ArrayList<>();
        switch (i) {
            case 6:
                lst.add(3);
                return lst;
            case 7:
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            case 8:
                lst.add(1);
                lst.add(2);
                lst.add(3);
                lst.add(4);
                lst.add(5);
                lst.add(6);
                lst.add(7);
                lst.add(8);
                lst.add(9);
                lst.add(13);
                lst.add(14);
                lst.add(15);
                lst.add(16);
                return lst;
            default:
                return null;
        }
    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow1(DrawSurface d, int x1, int y1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (blankPixelsInLine1(i + 1) != null && blankPixelsInLine1(i + 1).contains(j + 1)) {
                    continue;
                }
                d.setColor(Color.WHITE);
                d.fillRectangle(x + j * sizeOfPixelWidth, y + sizeOfPixelHeight * i, sizeOfPixelWidth,
                        sizeOfPixelHeight);
            }
        }

    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow2(DrawSurface d, int x1, int y1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (blankPixelsInLine2(i + 1) != null && blankPixelsInLine2(i + 1).contains(j + 1)) {
                    continue;
                }
                d.setColor(Color.WHITE);
                d.fillRectangle(x + j * sizeOfPixelWidth, y + sizeOfPixelHeight * i, sizeOfPixelWidth,
                        sizeOfPixelHeight);
            }
        }

    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow3(DrawSurface d, int x1, int y1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (blankPixelsInLine3(i + 1) != null && blankPixelsInLine3(i + 1).contains(j + 1)) {
                    continue;
                }
                d.setColor(Color.WHITE);
                d.fillRectangle(x + j * sizeOfPixelWidth, y + sizeOfPixelHeight * i, sizeOfPixelWidth,
                        sizeOfPixelHeight);
            }
        }
    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow4(DrawSurface d, int x1, int y1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (blankPixelsInLine4(i + 1) != null && blankPixelsInLine4(i + 1).contains(j + 1)) {
                    continue;
                }
                d.setColor(Color.WHITE);
                d.fillRectangle(x + j * sizeOfPixelWidth, y + sizeOfPixelHeight * i, sizeOfPixelWidth,
                        sizeOfPixelHeight);
            }
        }

    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow5(DrawSurface d, int x1, int y1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (blankPixelsInLine5(i + 1) != null && blankPixelsInLine5(i + 1).contains(j + 1)) {
                    continue;
                }
                d.setColor(Color.WHITE);
                d.fillRectangle(x + j * sizeOfPixelWidth, y + sizeOfPixelHeight * i, sizeOfPixelWidth,
                        sizeOfPixelHeight);
            }
        }
    }

    /**
     * @param d  is the draw surface to draw on
     * @param x1 is the x place to draw the snow in x axis
     * @param y1 is the y place to draw the snow in y axis
     */
    public void drawSnow(DrawSurface d, int x1, int y1) {
        switch (this.type) {
            case 1:
                drawSnow1(d, x1, y1);
                return;
            case 2:
                drawSnow2(d, x1, y1);
                return;
            case 3:
                drawSnow3(d, x1, y1);
                return;
            case 4:
                drawSnow4(d, x1, y1);
                return;
            case 5:
                drawSnow5(d, x1, y1);
            default:
                break;
        }
    }

    /**
     * This function draws the block.
     *
     * @param d       is the draw surface to draw on
     * @param x1      is the x place to draw the snow in x axis
     * @param y1      is the y place to draw the snow in y axis
     * @param width1  is the width of the block
     * @param height1 is the height of the block
     * @param color1  is the color of the block
     */
    public void drawBlock(DrawSurface d, int x1, int y1, int width1, int height1, Color color1) {
        d.setColor(color1);
        d.fillRectangle(x1, y1, width1, height1);
        d.setColor(Color.black);
        d.drawRectangle(x1, y1, width1, height1);
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawBlock(d, this.x, this.y, this.width, this.height, this.color);
        drawSnow(d, this.x, this.y);
    }

    @Override
    public void timePassed() {

    }
}

