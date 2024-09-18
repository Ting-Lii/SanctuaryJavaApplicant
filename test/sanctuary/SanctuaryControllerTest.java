package sanctuary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primates.*;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for SanctuaryController class using MockSanctuaryModel and a stubbed SanctuaryView.
 */
public class SanctuaryControllerTest {

    private MockSanctuaryModel mockModel;
    private StubbedSanctuaryView stubbedView;
    private SanctuaryController controller;

    @BeforeEach
    void setUp() {
        mockModel = new MockSanctuaryModel();
        stubbedView = new StubbedSanctuaryView();
        controller = new SanctuaryController(mockModel, stubbedView);
    }

    /**
     * Test the registration of a new monkey.
     */
    @Test
    void testRegisterNewMonkey() {
        stubbedView.setNameInput("George");
        stubbedView.setSpeciesInput(Species.SPIDER);
        stubbedView.setSexInput(Sex.MALE);
        stubbedView.setSizeInput(10.0);
        stubbedView.setWeightInput(15.0);
        stubbedView.setAgeInput(5);
        stubbedView.setFoodInput(Food.INSECTS);

        // Simulate the action of registering a new monkey
        stubbedView.getRegisterButton().doClick();

        // Diagnostic print statement
        System.out.println("Mock log: " + mockModel.getLog());

        // Check the log for the call
        String expectedLogPart = "addMonkeyToIsolation called with: ";
        assertTrue(mockModel.getLog().contains(expectedLogPart),
                "Expected the log to contain '" + expectedLogPart + "', but it was: " + mockModel.getLog());
    }

    /**
     * Test the transfer of a monkey from isolation to an enclosure.
     */
    @Test
    void testTransferMonkey() {
        // Setup the monkey to be transferred
        Monkey monkeyToTransfer = new Monkey("George", Species.SPIDER, Sex.MALE, 10.0, 15.0, 5, Food.INSECTS);
        stubbedView.setSelectedMonkeyFromIsolation(monkeyToTransfer);

        // Trigger the transfer action
        stubbedView.getTransferButton().doClick();

        // Check that the transfer method was called
        assertTrue(mockModel.getLog().contains("moveMonkeyToEnclosure called with: "),
                "Expected log to contain 'moveMonkeyToEnclosure called with:', but it was: " + mockModel.getLog());
    }

    /**
     * Test the display of enclosure details.
     */
    @Test
    void testShowEnclosureDetails() {
        // Trigger the show enclosures action
        stubbedView.getShowAllEnclosuresButton().doClick();

        // Check that the show enclosure details method was called
        assertTrue(mockModel.getLog().contains("listMonkeysInAllEnclosures called"),
                "Expected log to contain 'listMonkeysInAllEnclosures called', but it was: " + mockModel.getLog());
    }

    /**
     * Test the display of all monkeys in isolation.
     */
    @Test
    void testShowAlphabeticalList() {
        // Trigger the show alphabetical list action
        stubbedView.getShowAllMonkeysButton().doClick();

        // Check that the alphabetical list method was called
        assertTrue(mockModel.getLog().contains("listAllMonkeys called"),
                "Expected log to contain 'listAllMonkeys called', but it was: " + mockModel.getLog());
    }

    /**
     * Stubbed implementation of the SanctuaryView for testing purposes.
     * It provides setters for input values and simulates user actions.
     */
    private class StubbedSanctuaryView extends SanctuaryView {
        private String nameInput;
        private Species speciesInput;
        private Sex sexInput;
        private double sizeInput;
        private double weightInput;
        private int ageInput;
        private Food foodInput;
        private final JButton registerButton = new JButton();

        private Monkey selectedMonkeyFromIsolation;

        public void setSelectedMonkeyFromIsolation(Monkey monkey) {
            this.selectedMonkeyFromIsolation = monkey;
        }

        @Override
        public Monkey getSelectedMonkeyFromIsolation() {
            return this.selectedMonkeyFromIsolation;
        }

        public void setNameInput(String nameInput) {
            this.nameInput = nameInput;
        }

        public void setSpeciesInput(Species speciesInput) {
            this.speciesInput = speciesInput;
        }

        public void setSexInput(Sex sexInput) {
            this.sexInput = sexInput;
        }

        public void setSizeInput(double sizeInput) {
            this.sizeInput = sizeInput;
        }

        public void setWeightInput(double weightInput) {
            this.weightInput = weightInput;
        }

        public void setAgeInput(int ageInput) {
            this.ageInput = ageInput;
        }

        public void setFoodInput(Food foodInput) {
            this.foodInput = foodInput;
        }

        // Stubbed methods to simulate user input
        public String getNameInput() {
            return nameInput;
        }

        public Species getSpeciesInput() {
            return speciesInput;
        }

        public Sex getSexInput() {
            return sexInput;
        }

        public double getSizeInput() {
            return sizeInput;
        }

        public double getWeightInput() {
            return weightInput;
        }

        public int getAgeInput() {
            return ageInput;
        }

        public Food getFoodInput() {
            return foodInput;
        }

        public JButton getRegisterButton() {
            // In an actual view, this button would have an action listener that calls controller.registerNewMonkey().
            // For this stub, it's just a mock button for testing.
            return registerButton;
        }

        // Mock displayMessage method
        public void displayMessage(String message) {
            // This method would update the UI in a real view. Here, it can be left empty or print to the console.
            System.out.println(message);
        }

    }
}
