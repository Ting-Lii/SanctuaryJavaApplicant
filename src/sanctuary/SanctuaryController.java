package sanctuary; /**
 * The SanctuaryController class handles the interactions between the model and view in the sanctuary management application.
 * It responds to user input from the SanctuaryView and updates the Sanctuary model accordingly.
 */
import primates.*;

import java.util.List;

public class SanctuaryController {
    private ISanctuaryModel model;
    private SanctuaryView view;

    /**
     * Constructs a SanctuaryController with the specified model and view.
     *
     * @param model the Sanctuary model to be controlled
     * @param view  the SanctuaryView that provides the user interface
     */
    public SanctuaryController(ISanctuaryModel model, SanctuaryView view) {
        this.model = model;
        this.view = view;

        // Register button action listener
        view.getRegisterButton().addActionListener(e -> registerNewMonkey());
        // Transfer button action listener
        view.getTransferButton().addActionListener(e -> transferMonkey());
        // Enclosure details button action listener
        view.getShowAllEnclosuresButton().addActionListener(e -> showEnclosureDetails()); // Updated method name
        // Alphabetical list button action listener
        view.getShowAllMonkeysButton().addActionListener(e -> showAlphabeticalList());
    }

    /**
     * Registers a new monkey with the information provided through the view.
     * If successful, the monkey is added to isolation, otherwise, an appropriate message is displayed.
     */
    private void registerNewMonkey() {
        try {
            String name = view.getNameInput();
            Species species = view.getSpeciesInput();
            Sex sex = view.getSexInput();
            double size = view.getSizeInput();
            double weight = view.getWeightInput();
            int age = view.getAgeInput();
            Food favoriteFood = view.getFoodInput();

            // Create a new monkey object
            Monkey newMonkey = new Monkey(name, species, sex, size, weight, age, favoriteFood);

            // Attempt to add monkey to the sanctuary's isolation
            if (model.addMonkeyToIsolation(newMonkey)) {
                view.displayMessage("Monkey registered successfully and placed in isolation.");
                // Refresh the list of monkeys in isolation to include the new one
                refreshIsolationList();
            } else {
                view.displayMessage("All isolation cages are full.");
            }
        } catch (NumberFormatException e) {
            view.displayMessage("Please ensure all input fields are filled correctly.");
        }
    }

    /**
     * Transfers a monkey from isolation to a species-specific enclosure.
     * Displays a message based on the outcome of the operation.
     */
    private void transferMonkey() {
        Monkey selectedMonkey = view.getSelectedMonkeyFromIsolation();
        if (selectedMonkey == null) {
            view.displayMessage("Please select a monkey from isolation to transfer.");
            return;
        }

        if (model.moveMonkeyToEnclosure(selectedMonkey)) {
            view.displayMessage("Monkey transferred successfully to its species-specific enclosure.");
            refreshIsolationList(); // This will update the combobox
        } else {
            view.displayMessage("Failed to transfer monkey. Please ensure the monkey is in isolation and there is space in the enclosure.");
        }
    }

    /**
     * Displays the details of all enclosures in the sanctuary by updating the view.
     */
    private void showEnclosureDetails() {
        List<String> enclosuresInfo = model.listMonkeysInAllEnclosures();
        StringBuilder sb = new StringBuilder();
        for (String info : enclosuresInfo) {
            sb.append(info).append("\n");
        }
        view.updateMonkeysList(sb.toString());
    }

    /**
     * Shows an alphabetical list of all monkeys in the sanctuary by updating the view.
     */
    private void showAlphabeticalList() {
        List<Monkey> monkeys = model.listAllMonkeys();
        StringBuilder sb = new StringBuilder();
        for (Monkey monkey : monkeys) {
            sb.append(monkey.toString()).append("\n");
        }
        view.updateMonkeysList(sb.toString());
    }

    /**
     * Refreshes the list of monkeys in isolation displayed in the view.
     */
    public void refreshIsolationList() {
        List<Monkey> monkeysInIsolation = model.listAllMonkeysInIsolation();
        view.refreshIsolationList(monkeysInIsolation.toArray(new Monkey[0]));
    }
}
