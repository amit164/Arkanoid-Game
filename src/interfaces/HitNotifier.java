package interfaces;

/**
 * This interface represent any notifier to hit action. It requires the hit notifiers to add and remove lisenters
 * accordingly to what happened.
 */
public interface HitNotifier {
    /**
     * The function add a listener to hit events.
     *
     * @param hl is the listener to add
     */
    void addHitListener(HitListener hl);

    /**
     * The function remove a listener to hit events.
     *
     * @param hl is the listener to remove
     */
    void removeHitListener(HitListener hl);
}
