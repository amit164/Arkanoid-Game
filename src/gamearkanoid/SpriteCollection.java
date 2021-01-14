package gamearkanoid; /**
 * @author Amit Sharabi
 * 323784298
 */

import interfaces.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the sprite collection. GameArkanoid.SpriteCollection holds a collection of sprites objects.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor function. The function create new sprite list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * The function add the given sprite to the environment.
     *
     * @param s is a collidable to add
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * The function delete a sprite from the list.
     *
     * @param s is the sprite object to remove.
     */
    public void deleteSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * The function call timePassed() on al sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> list = new ArrayList<>(this.sprites);
        for (Sprite sprite : list) {
            sprite.timePassed();
        }
    }

    /**
     * The function call drawOn(d) on all sprites.
     *
     * @param d is the draw surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }
}