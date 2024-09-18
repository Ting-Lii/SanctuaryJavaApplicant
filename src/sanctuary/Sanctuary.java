package sanctuary;

import primates.Enclosure;
import primates.Isolation;
import primates.Monkey;
import primates.Species;

import java.util.*;

/**
 * Represents a sanctuary for housing primates, consisting of isolation cages and enclosures.
 */
public class Sanctuary implements ISanctuaryModel{
    private List<Isolation> isolations = new ArrayList<>();
    //assign every species with an enclosure.
    private Map<Species, Enclosure> enclosures = new TreeMap<>();
    protected static final int MAX_ISOLATION = 20;
    protected static final int MAX_ENCLOSURE = 8;

    /**
     * Constructs a sanctuary with isolation cages and enclosures for various monkey species.
     */
    public Sanctuary() {
        // Initialize isolation cages
        for (int i = 0; i < MAX_ISOLATION; i++) {
            isolations.add(new Isolation());
        }

        // Initialize enclosures for each species
        for (Species species : Species.values()) {
            enclosures.put(species, new Enclosure(species));
        }
    }

    /**
     * Adds a monkey to an available isolation cage in the sanctuary.
     *
     * @param monkey the monkey to be added to isolation
     * @return true if the monkey is successfully added to isolation, false if all cages are full
     */
    public boolean addMonkeyToIsolation(Monkey monkey) {
        for (Isolation cage : isolations) {
            if (cage.addMonkey(monkey)) {
                return true;
            }
        }
        return false; // All cages are full
    }

    /**
     * Moves a monkey from isolation to the species-specific enclosure.
     *
     * @param monkey the monkey to be moved to an enclosure
     * @return true if the monkey is successfully moved to an enclosure, false otherwise
     */
    public boolean moveMonkeyToEnclosure(Monkey monkey) {
        Isolation cageToRemoveFrom = null;

        for (Isolation cage : isolations) {
            if (cage.getMonkey() != null && cage.getMonkey().equals(monkey)) {
                cageToRemoveFrom = cage;
                break;
            }
        }

        // If the monkey was found in an isolation cage, attempt to move it to the according enclosure
        if (cageToRemoveFrom != null) {
            // Remove the monkey from the isolation cage
            boolean removedFromIsolation = cageToRemoveFrom.removeMonkey(monkey);

            // If removal was successful, add the monkey to its species-specific enclosure
            if (removedFromIsolation) {
                Enclosure enclosure = enclosures.get(monkey.getSpecies());
                if (enclosure != null) {
                    return enclosure.addMonkey(monkey);
                }
            }
        }
        // Return false if the monkey wasn't found in any isolation cage or couldn't be added to an enclosure
        return false;
    }

    /**
     * Lists details of monkeys in all enclosures of the sanctuary.
     *
     * @return a list of string representations of monkeys in enclosures
     */
    public List<String> listMonkeysInAllEnclosures() {
        List<String> enclosuresDetails = new ArrayList<>();
        //iterate every set of enclosures, and add the detail to the enclosuresDetails list.
        for (Map.Entry<Species, Enclosure> entry : enclosures.entrySet()) {
            String enclosureDetail = entry.getValue().toString();
            enclosuresDetails.add(enclosureDetail);
        }
        return enclosuresDetails;
    }

    /**
     * Lists all monkeys currently in the sanctuary, including those in isolation and enclosures,
     * alphabetically by name.
     *
     * @return a list of all monkeys in the sanctuary, sorted alphabetically by name
     */
    public List<Monkey> listAllMonkeys() {
        List<Monkey> allMonkeys = new ArrayList<>();
        // Add all monkeys from isolation cages
        for (Isolation cage : isolations) {
            if (cage.getMonkey() != null) {
                allMonkeys.add(cage.getMonkey());
            }
        }
        // Add all monkeys from enclosures
        for (Enclosure enclosure : enclosures.values()) {
            allMonkeys.addAll(enclosure.getMonkeys());
        }
        // Sort alphabetically by name
        allMonkeys.sort(Comparator.comparing(Monkey::getName));
        return allMonkeys;
    }

    /**
     * Lists all monkeys currently in isolation cages.
     *
     * @return a list of all monkeys currently in isolation, sorted alphabetically by name
     */
    public List<Monkey> listAllMonkeysInIsolation() {
        List<Monkey> monkeysInIsolation = new ArrayList<>();
        for (Isolation isolation : isolations) {
            if (isolation.getMonkey() != null) {
                monkeysInIsolation.add(isolation.getMonkey());
            }
        }
        monkeysInIsolation.sort(Comparator.comparing(Monkey::getName));
        return monkeysInIsolation;
    }

}
