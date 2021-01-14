package graphics;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent icicles and show it on screen.
 */
public class Icicles implements Sprite {
    private static int sizeOfPixel = 5;

    /**
     * @param i is the line
     * @return a list of Colors in this line
     */
    public static List<Color> colorInLine1(int i) {
        List<Color> lst = new ArrayList<>();
        switch (i) {
            case 1:
                for (int j = 0; j < 31; j++) {
                    lst.add(new Color(195, 235, 239));
                }
                lst.add(new Color(124, 205, 215));
                return lst;
            case 2:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(222, 239, 242));
                for (int j = 0; j < 3; j++) {
                    lst.add(new Color(195, 235, 239));
                }
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 5; j++) {
                    lst.add(new Color(195, 235, 239));
                }
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                return lst;
            case 3:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 4:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(null);
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 5:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                return lst;
            default:
                return null;
        }
    }

    /**
     * @param i is the line
     * @return a list of Colors in this line
     */
    public static List<Color> colorInLine2(int i) {
        List<Color> lst = new ArrayList<>();
        switch (i) {
            case 6:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 7:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(null);
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 3; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 8:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 9:
                lst.add(null);
                lst.add(new Color(222, 239, 242));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            default:
                return null;
        }
    }

    /**
     * @param i is the line
     * @return a list of Colors in this line
     */
    public static List<Color> colorInLine3(int i) {
        List<Color> lst = new ArrayList<>();
        switch (i) {
            case 10:
                lst.add(null);
                lst.add(null);
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 11:
                lst.add(null);
                lst.add(null);
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 4; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                return lst;
            case 12:
                lst.add(null);
                lst.add(null);
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 6; j++) {
                    lst.add(null);
                }
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 5; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 5; j++) {
                    lst.add(null);
                }
                lst.add(new Color(50, 51, 65));
                lst.add(null);
                for (int j = 0; j < 5; j++) {
                    lst.add(null);
                }
                lst.add(new Color(50, 51, 65));
                return lst;
            case 13:
                lst.add(null);
                lst.add(null);
                lst.add(new Color(195, 235, 239));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 12; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 14; j++) {
                    lst.add(null);
                }
                return lst;
            case 14:
                lst.add(null);
                lst.add(null);
                lst.add(null);
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 12; j++) {
                    lst.add(null);
                }
                lst.add(new Color(124, 205, 215));
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 14; j++) {
                    lst.add(null);
                }
                return lst;
            case 15:
                for (int j = 0; j < 17; j++) {
                    lst.add(null);
                }
                lst.add(new Color(50, 51, 65));
                for (int j = 0; j < 14; j++) {
                    lst.add(null);
                }
                return lst;
            default:
                return null;
        }
    }

    /**
     * @param d is the draw surface to draw on
     * @param x is the place to start the icicles in x axis
     * @param y is the place to start the icicles in y axis
     */
    public static void drawOne(DrawSurface d, int x, int y) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 32; j++) {
                if (colorInLine(i + 1).get(j) != null) {
                    d.setColor(colorInLine(i + 1).get(j));
                    d.fillRectangle(x + j * sizeOfPixel, y + sizeOfPixel * i, sizeOfPixel, sizeOfPixel);
                }
            }
        }
    }

    /**
     * @param i is the line
     * @return a list of Colors in this line
     */
    private static List<Color> colorInLine(int i) {
        if (i >= 10) {
            return colorInLine3(i);
        } else if (i >= 6) {
            return colorInLine2(i);
        } else {
            return colorInLine1(i);
        }
    }


    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 5; i++) {
            drawOne(d, i * 160, 22);
        }
    }

    @Override
    public void timePassed() {
    }
}
