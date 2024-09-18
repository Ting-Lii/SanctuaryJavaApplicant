package primates;

/**
 * Represents a primates with attributes including name, species, sex, size, weight, age, and favorite food.
 */
public class Monkey {
    private String name;
    private Species species;
    private Sex sex;
    private double size;
    private double weight;
    private int age;
    private Food favoriteFood;

    /**
     * Constructor of primates.Monkey.
     *
     * @param name         the name of the monkey
     * @param species      the species of the monkey
     * @param sex          the sex of the monkey
     * @param size         the size of the monkey
     * @param weight       the weight of the monkey
     * @param age          the age of the monkey
     * @param favoriteFood the favorite food of the monkey
     */
    public Monkey(String name, Species species, Sex sex, double size, double weight, int age, Food favoriteFood) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    /**
     * Retrieves the name of the monkey.
     *
     * @return the name of the monkey
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the species of the monkey.
     *
     * @return the species of the monkey
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Retrieves the sex of the monkey.
     *
     * @return the sex of the monkey
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Retrieves the size of the monkey.
     *
     * @return the size of the monkey
     */
    public double getSize() {
        return size;
    }

    /**
     * Retrieves the weight of the monkey.
     *
     * @return the weight of the monkey
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Retrieves the age of the monkey.
     *
     * @return the age of the monkey
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the favorite food of the monkey.
     *
     * @return the favorite food of the monkey
     */
    public Food getFavoriteFood() {
        return favoriteFood;
    }

    /**
     * Returns a string representation of the primates.Monkey object.
     *
     * @return a string representation of the primates.Monkey object
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Sex: " + sex + ", Favorite Food: " + favoriteFood;
    }
}