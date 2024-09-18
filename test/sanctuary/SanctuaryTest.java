package sanctuary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sanctuary.Sanctuary;
import primates.*;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SanctuaryTest {
    private Sanctuary sanctuary;

    @BeforeEach
    void setUp() {
        sanctuary = new Sanctuary();
    }

    @Test
    void addMonkeyToIsolationWhenSpaceAvailable() {
        Monkey monkey = new Monkey("TestMonkey", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        Assertions.assertTrue(sanctuary.addMonkeyToIsolation(monkey));
    }

    @Test
    void addMonkeyToIsolationWhenFull() {
        // Fill up the isolation cages to MAX_ISOLATION
        for (int i = 0; i < Sanctuary.MAX_ISOLATION; i++) {
            sanctuary.addMonkeyToIsolation(new Monkey("primates.Monkey" + i, Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS));
        }
        // Try adding another monkey
        Monkey extraMonkey = new Monkey("ExtraMonkey", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        Assertions.assertFalse(sanctuary.addMonkeyToIsolation(extraMonkey));
    }

    @Test
    void moveMonkeyToEnclosureSuccessfully() {
        Monkey monkey = new Monkey("EnclosureMonkey", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        sanctuary.addMonkeyToIsolation(monkey);
        Assertions.assertTrue(sanctuary.moveMonkeyToEnclosure(monkey));
    }

    @Test
    void moveMonkeyToEnclosureUnsuccessfully() {
        Monkey monkey = new Monkey("NotInIsolation", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        // Not adding the monkey to isolation first
        Assertions.assertFalse(sanctuary.moveMonkeyToEnclosure(monkey));
    }

    @Test
    void listMonkeysInAllEnclosuresAfterAddingMonkeys() {
        // Add and move a monkey to ensure it's in an enclosure
        Monkey monkey = new Monkey("ListedMonkey", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        sanctuary.addMonkeyToIsolation(monkey);
        sanctuary.moveMonkeyToEnclosure(monkey);

        List<String> enclosuresDetails = sanctuary.listMonkeysInAllEnclosures();
        assertFalse(enclosuresDetails.isEmpty());
        // Further validation can depend on the format of the returned strings
    }

    @Test
    void listAllMonkeysIncludesBothIsolationAndEnclosure() {
        // Add monkey to isolation only
        Monkey isolatedMonkey = new Monkey("IsolatedMonkey", Species.SPIDER, Sex.MALE, 1.0, 30.0, 5, Food.INSECTS);
        sanctuary.addMonkeyToIsolation(isolatedMonkey);

        // Add and move monkey to enclosure
        Monkey enclosureMonkey = new Monkey("EnclosureMonkey", Species.TAMARIN, Sex.FEMALE, 0.8, 25.0, 4, Food.LEAVES);
        sanctuary.addMonkeyToIsolation(enclosureMonkey);
        sanctuary.moveMonkeyToEnclosure(enclosureMonkey);

        List<Monkey> allMonkeys = sanctuary.listAllMonkeys();
        assertTrue(allMonkeys.contains(isolatedMonkey) && allMonkeys.contains(enclosureMonkey), "Should include both isolated and enclosure monkeys.");
    }
}
