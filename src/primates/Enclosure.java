package primates;

import java.util.ArrayList;
import java.util.List;

/**
 * This class primates.Enclosure only hold the same species of primates.
 */
public class Enclosure implements House {
    private List<Monkey> monkeyTroop = new ArrayList<>();
    private Species species;
    /**
     * Constructor of primates.Enclosure.
     *
     * @param species the species of monkeys the enclosure is intended for
     */
    public Enclosure(Species species) {
        this.species = species;
    }

    /**
     * Adds a monkey to this enclosure.It can only be successful when the same species.
     *
     * @param monkey the monkey to be added
     * @return true if the monkey is successfully added, false otherwise
     */
    @Override
    public boolean addMonkey(Monkey monkey) {
        if (monkey.getSpecies() == this.species){
            monkeyTroop.add(monkey);
            return true;
        }
        return false;
    }

    /**
     * Removes a monkey from the enclosure.
     *
     * @param monkey the monkey to be removed
     * @return true if the monkey is successfully removed, false otherwise
     */
    @Override
    public boolean removeMonkey(Monkey monkey) {
        return monkeyTroop.remove(monkey);
    }

    /**
     * Retrieves the list of monkeys currently housed in the enclosure.
     *
     * @return the list of monkeys in the enclosure
     */
    public List<Monkey> getMonkeys(){
        return this.monkeyTroop;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Enclosure for species " + species + ":\n");
        for (Monkey monkey : monkeyTroop) {
            s.append(monkey).append("\n");
        }
        return s.toString().trim();
    }
}
