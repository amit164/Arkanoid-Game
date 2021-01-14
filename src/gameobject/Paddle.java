package gameobject;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Sprite;
import interfaces.Collidable;
import gamearkanoid.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author Amit Sharabi
 * 323784298
 */

/**
 * This class represent a paddle object. The GameObjects.Paddle is the player in the game. It is a rectangle that is
 * controlled by the arrow keys, and moves according to the player key presses. GameObjects.Paddle is also a sprite
 * and collidable object.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int width;
    private int speed;

    private static final double EP = Math.pow(10, -10);
    private static final int BORDER_OF_LEFT_BOARD = 25;
    private static final int BORDER_OF_RIGHT_BOARD = 780;
    private static final int HEIGHT_OF_PADDLE = 20;
    private static final int PARTS = 5;
    private static final int CHANGE_VELOCITY = -1;
    private static final int PART_ONE_ANGLE = 300;
    private static final int PART_TWO_ANGLE = 330;
    private static final int PART_FOUR_ANGLE = 30;
    private static final int PART_FIVE_ANGLE = 60;
    private static final int X_PLACE_OF_PADDLE = 350;
    private static final int Y_PLACE_OF_PADDLE = 558;


    /**
     * constructor function. The function create a paddle.
     *
     * @param speed    is the paddle speed
     * @param width    is the width of the paddle
     * @param keyboard is the direct to go
     * @param location is the location on the paddle
     */
    public Paddle(biuoop.KeyboardSensor keyboard, int width, int speed, Point location) {
        this.width = width;
        this.keyboard = keyboard;
        this.rectangle = new Rectangle(new Point(location), this.width, HEIGHT_OF_PADDLE);
        this.color = new Color(134, 213, 234);
        this.speed = speed;
    }

    /**
     * The function moves the paddle to the left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() >= BORDER_OF_LEFT_BOARD) {
            this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() - this.speed,
                    this.rectangle.getUpperLeft().getY()), this.width, HEIGHT_OF_PADDLE);
        }
    }

    /**
     * The function moves the paddle to the upper.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.width <= BORDER_OF_RIGHT_BOARD) {
            this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() + this.speed,
                    this.rectangle.getUpperLeft().getY()), this.width, HEIGHT_OF_PADDLE);
        }
    }

    // Intefaces.Sprite

    /**
     * The function moves the paddle is the key pressed.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else {
            if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
                moveRight();
            }
        }
    }

    /**
     * The function draw the block on the given DrawSurface.
     *
     * @param d is a DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.white);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        drawIcePaddle(d);
    }

    // Intefaces.Collidable

    /**
     * @return the "collision shape" of the object - rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the paddle that we collided with it at collisionPoint with a given velocity. The function checks where
     * the collision happend on the rectangle and return the new velocity expected after the hit
     *
     * @param hitter          is the ball that hit the paddle
     * @param collisionPoint  is the collisn point of the object
     * @param currentVelocity is the velocity of the object the colliede with.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double velocity = Math.sqrt(dx * dx + dy * dy);
        double newWidth = this.rectangle.getWidth() / PARTS;
        Line part1 = new Line(this.rectangle.getUpperLeft(), new Point(this.rectangle.getUpperLeft().getX() + newWidth,
                this.rectangle.getUpperLeft().getY()));
        Line part2 = new Line(part1.end(), new Point(part1.end().getX() + newWidth, part1.end().getY()));
        Line part3 = new Line(part2.end(), new Point(part2.end().getX() + newWidth, part2.end().getY()));
        Line part4 = new Line(part3.end(), new Point(part3.end().getX() + newWidth, part3.end().getY()));
        Line part5 = new Line(part4.end(), new Point(this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth(), part4.end().getY()));
        /*if (Math.abs(this.rectangle.getUpperLeft().getX() - collisionPoint.getX()) <= EP
                || Math.abs(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()
                - collisionPoint.getX()) <= EP) {
            return new Velocity(CHANGE_VELOCITY * dx, dy);
        }*/
        if (Math.abs(this.rectangle.getUpperLeft().getY() - collisionPoint.getY()) <= EP) {
            //|| Math.abs(this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight()
            //- collisionPoint.getY()) <= EP) {
            if (part1.inXRange(collisionPoint.getX())) {
                return Velocity.fromAngleAndSpeed(PART_ONE_ANGLE, velocity);
            }
            if (part2.inXRange(collisionPoint.getX())) {
                return Velocity.fromAngleAndSpeed(PART_TWO_ANGLE, velocity);
            }
            if (part3.inXRange(collisionPoint.getX())) {
                return new Velocity(dx, CHANGE_VELOCITY * dy);
            }
            if (part4.inXRange(collisionPoint.getX())) {
                return Velocity.fromAngleAndSpeed(PART_FOUR_ANGLE, velocity);
            }
            if (part5.inXRange(collisionPoint.getX())) {
                return Velocity.fromAngleAndSpeed(PART_FIVE_ANGLE, velocity);
            }
        }
        return currentVelocity;
    }

    /**
     * The function add the paddle to the game.
     *
     * @param g is the game to add to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This function draws 3 ice pixels in paddle.
     *
     * @param d is the draw surface to draw on
     * @param x is the place to start to draw on x axis
     * @param y is the place to start to draw on y axis
     */
    public void draw3Pixels(DrawSurface d, int x, int y) {
        d.fillRectangle(x, y, 3, 3);
        d.fillRectangle(x + 3, y - 3, 3, 3);
        d.fillRectangle(x + 6, y - 6, 3, 3);
    }

    /**
     * This function draws ices in the paddle.
     *
     * @param surface is the draw surface to draw on
     */
    public void drawIcePaddle(DrawSurface surface) {
        surface.setColor(new Color(135, 227, 250));
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        surface.setColor(Color.WHITE);
        draw3Pixels(surface, (int) (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 3),
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() / 2));
        draw3Pixels(surface, (int) (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 2),
                (int) (this.rectangle.getUpperLeft().getY() + 2 * this.rectangle.getHeight() / 3));
        draw3Pixels(surface, (int) (this.rectangle.getUpperLeft().getX() + 2 * this.rectangle.getWidth() / 3),
                (int) (this.rectangle.getUpperLeft().getY() + 2 * this.rectangle.getHeight() / 3));
        draw3Pixels(surface, (int) (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 4),
                (int) (this.rectangle.getUpperLeft().getY() + 3 * this.rectangle.getHeight() / 4));
    }
}