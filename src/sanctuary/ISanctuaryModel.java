package sanctuary;

import primates.Monkey;

import java.util.List;

/**
 * Interface defining the operations for managing a sanctuary that houses primates.
 */
public interface ISanctuaryModel {

    /**
     * Adds a monkey to an available isolation cage in the sanctuary.
     *
     * @param monkey the monkey to be added to isolation
     * @return true if the monkey is successfully added to isolation, false if all cages are full
     */
    boolean addMonkeyToIsolation(Monkey monkey);

    /**
     * Moves a monkey from isolation to the species-specific enclosure.
     *
     * @param monkey the monkey to be moved to an enclosure
     * @return true if the monkey is successfully moved to an enclosure, false otherwise
     */
    boolean moveMonkeyToEnclosure(Monkey monkey);

    /**
     * Lists details of monkeys in all enclosures of the sanctuary.
     *
     * @return a list of string representations of monkeys in enclosures
     */
    List<String> listMonkeysInAllEnclosures();

    /**
     * Lists all monkeys currently in the sanctuary, including those in isolation and enclosures,
     * alphabetically by name.
     *
     * @return a list of all monkeys in the sanctuary, sorted alphabetically by name
     */
    List<Monkey> listAllMonkeys();

    /**
     * Lists all monkeys currently in isolation cages.
     *
     * @return a list of all monkeys currently in isolation, sorted alphabetically by name
     */
    List<Monkey> listAllMonkeysInIsolation();
}