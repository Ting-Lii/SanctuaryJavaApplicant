package primates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primates.Food;
import primates.Monkey;
import primates.Sex;
import primates.Species;

class MonkeyTest {
    private Monkey monkey;

    @BeforeEach
    void setUp() {
        monkey = new Monkey("Zazu", Species.SQUIRREL, Sex.UNCERTAIN, 0.5, 20.0, 10, Food.NUTS);
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("Zazu", monkey.getName());
    }

    @Test
    void testGetSpecies() {
        Assertions.assertEquals(Species.SQUIRREL, monkey.getSpecies());
    }

    @Test
    void testGetSex() {
        Assertions.assertEquals(Sex.UNCERTAIN, monkey.getSex());
    }

    @Test
    void testGetSize() {
        Assertions.assertEquals(0.5, monkey.getSize());
    }

    @Test
    void testGetWeight() {
        Assertions.assertEquals(20.0, monkey.getWeight());
    }

    @Test
    void testGetAge() {
        Assertions.assertEquals(10, monkey.getAge());
    }

    @Test
    void testGetFavoriteFood() {
        Assertions.assertEquals(Food.NUTS, monkey.getFavoriteFood());
    }

    @Test
    void testToString() {
        String expectedToString = "Name: Zazu, Sex: UNCERTAIN, Favorite Food: NUTS";
        Assertions.assertEquals(expectedToString, monkey.toString());
    }
}
