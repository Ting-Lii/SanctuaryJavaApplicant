package primates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primates.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnclosureTest {
    private Enclosure enclosure;
    private Monkey spiderMonkey;
    private Monkey tamarinMonkey;

    @BeforeEach
    void setUp() {
        enclosure = new Enclosure(Species.SPIDER);
        spiderMonkey = new Monkey("Coco", Species.SPIDER, Sex.FEMALE, 1.0, 30.0, 5, Food.FRUITS);
        tamarinMonkey = new Monkey("Gigi", Species.TAMARIN, Sex.MALE, 0.5, 15.0, 3, Food.NUTS);
    }

    @Test
    void testAddMonkeySameSpecies() {
        assertTrue(enclosure.addMonkey(spiderMonkey), "Should successfully add a spider monkey to a spider enclosure");
        assertTrue(enclosure.getMonkeys().contains(spiderMonkey), "The enclosure should contain the spider monkey");
    }

    @Test
    void testAddMonkeyDifferentSpecies() {
        assertFalse(enclosure.addMonkey(tamarinMonkey), "Should fail to add a tamarin monkey to a spider enclosure");
        assertFalse(enclosure.getMonkeys().contains(tamarinMonkey), "The enclosure should not contain the tamarin monkey");
    }

    @Test
    void testRemoveMonkeyPresent() {
        enclosure.addMonkey(spiderMonkey);
        assertTrue(enclosure.removeMonkey(spiderMonkey), "Should successfully remove the spider monkey from the enclosure");
        assertFalse(enclosure.getMonkeys().contains(spiderMonkey), "The enclosure should no longer contain the spider monkey");
    }

    @Test
    void testRemoveMonkeyNotPresent() {
        enclosure.addMonkey(spiderMonkey);
        assertFalse(enclosure.removeMonkey(tamarinMonkey), "Should fail to remove a tamarin monkey that is not present in the spider enclosure");
        assertTrue(enclosure.getMonkeys().contains(spiderMonkey), "The enclosure should still contain the spider monkey");
    }

    @Test
    void testGetMonkeysEmptyEnclosure() {
        assertTrue(enclosure.getMonkeys().isEmpty(), "Should return an empty list for an empty enclosure");
    }

    @Test
    void testGetMonkeysNonEmptyEnclosure() {
        enclosure.addMonkey(spiderMonkey);
        List<Monkey> monkeys = enclosure.getMonkeys();
        assertNotNull(monkeys, "The list of monkeys should not be null");
        assertFalse(monkeys.isEmpty(), "The list of monkeys should not be empty");
        assertEquals(1, monkeys.size(), "The list of monkeys should contain one monkey");
        Assertions.assertEquals(spiderMonkey, monkeys.get(0), "The monkey in the list should be the spider monkey added");
    }

    @Test
    void testToString(){
        enclosure.addMonkey(spiderMonkey);
        String expected = "Enclosure for species SPIDER:\nName: Coco, Sex: FEMALE, Favorite Food: FRUITS";
        assertEquals(expected, enclosure.toString());
    }
}
