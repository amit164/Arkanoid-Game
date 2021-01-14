package gamearkanoid;

/**
 * This class represent a counter.
 */
public class Counter {
    private int count;

    /**
     * Constructor function.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * The function add number to current count.
     *
     * @param number is the number to add.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * The function subtract number from current count.
     *
     * @param number is the number to sub.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * @return the current count.
     */
    public int getValue() {
        return this.count;
    }
}
