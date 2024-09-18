package primates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primates.*;

class IsolationTest {
    private Isolation isolation;
    private Monkey coco;
    private Monkey gigi;

    @BeforeEach
    void setUp() {
        isolation = new Isolation();
        coco = new Monkey("Coco", Species.SPIDER, Sex.FEMALE, 1.0, 30.0, 5, Food.FRUITS);
        gigi = new Monkey("Gigi", Species.TAMARIN, Sex.MALE, 0.5, 15.0, 3, Food.NUTS);
    }

    @Test
    void testAddMonkeyToEmptyCage() {
        Assertions.assertTrue(isolation.addMonkey(coco), "Coco should be added to the empty cage");
        Assertions.assertEquals(coco, isolation.getMonkey(), "The monkey in the cage should be Coco");
    }

    @Test
    void testAddMonkeyToOccupiedCage() {
        isolation.addMonkey(coco);
        Assertions.assertFalse(isolation.addMonkey(gigi), "Gigi should not be added because the cage is occupied");
        Assertions.assertNotEquals(gigi, isolation.getMonkey(), "The monkey in the cage should not be Gigi");
    }

    @Test
    void testRemoveCorrectMonkeyFromCage() {
        isolation.addMonkey(coco);
        Assertions.assertTrue(isolation.removeMonkey(coco), "Coco should be removed from the cage");
        Assertions.assertNull(isolation.getMonkey(), "The cage should be empty after removing Coco");
    }

    @Test
    void testRemoveIncorrectMonkeyFromCage() {
        isolation.addMonkey(coco);
        Assertions.assertFalse(isolation.removeMonkey(gigi), "Gigi should not be removed because Gigi is not in the cage");
        Assertions.assertNotNull(isolation.getMonkey(), "The cage should not be empty because Gigi was not removed");
    }

    @Test
    void testRemoveMonkeyFromEmptyCage() {
        Assertions.assertFalse(isolation.removeMonkey(coco), "Coco should not be removed because the cage is empty");
        Assertions.assertNull(isolation.getMonkey(), "The cage should be empty");
    }
}

