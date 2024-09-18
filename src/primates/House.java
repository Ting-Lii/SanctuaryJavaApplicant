package primates;

/**
 * Interface representing a housing place for monkeys.
 */
public interface House {
    /**
     * Adds a monkey to the housing place.
     *
     * @param monkey the monkey to be added
     * @return true if the monkey is successfully added, false otherwise
     */
    boolean addMonkey(Monkey monkey);

    /**
     * Removes a monkey from the housing place.
     *
     * @param monkey the monkey to be removed
     * @return true if the monkey is successfully removed, false otherwise
     */
    boolean removeMonkey(Monkey monkey);
}
