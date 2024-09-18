package primates;

/**
 * primates.Isolation class consists of a series of cages each of which can house a single animal
 */
public class Isolation implements House{
    private Monkey monkey; // Initially null, indicating the isolation house is empty

    /**
     * Adds a monkey to the isolation house.
     *
     * @param monkey the monkey to be added
     * @return true if the monkey is successfully added (primates.Isolation is not occupied),
     * false otherwise
     */
    @Override
    public boolean addMonkey(Monkey monkey) {
        if (this.monkey == null) {
            this.monkey = monkey;
            return true;
        }
        return false;
    }


    /**
     * Removes a monkey from the isolation house.
     *
     * @param monkey the monkey to be removed
     * @return true if the monkey is successfully removed, false otherwise
     */
    @Override
    public boolean removeMonkey(Monkey monkey) {
        if (this.monkey != null && this.monkey.equals(monkey)){
            this.monkey = null;
            return true;
        }
        return false;
    }

    /**
     * Retrieve the monkey currently keeped in the isolation cage.
     *
     * @return the monkey currently housed in the isolation cage, or null if there is no monkey.
     */
    public Monkey getMonkey(){return this.monkey;}
}
