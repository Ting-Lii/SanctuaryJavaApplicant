package sanctuary;// SanctuaryView.java
import primates.Food;
import primates.Monkey;
import primates.Sex;
import primates.Species;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The SanctuaryView class provides the user interface for the sanctuary management application.
 * It contains methods to initialize and update the UI components and handle user actions via listeners.
 */
public class SanctuaryView extends JFrame {
    private JButton registerButton;
    private JButton transferButton;
    private JButton showAllEnclosuresButton;
    private JButton showAllMonkeysButton;
    private JTextArea listTextArea;
    private JTextField nameField, sizeField, weightField, ageField;
    private JComboBox<Species> speciesBox;
    private JComboBox<Sex> sexBox;
    private JComboBox<Food> foodBox;
    private JComboBox<Monkey> isolationMonkeys; // For selecting monkeys to transfer

    /**
     * Constructs the main window frame and initializes all UI components for the sanctuary management application.
     */
    public SanctuaryView() {
        super("Primate Sanctuary System");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BorderLayout to contain all subpanels
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create and add the Register Panel at the top (North)
        JPanel registerPanel = createRegisterPanel();
        mainPanel.add(registerPanel, BorderLayout.NORTH);

        // Create and add the Transfer Panel and Bottom Panel in the center area using a sub-panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel transferPanel = createTransferPanel();
        JPanel bottomPanel = createBottomPanel();
        centerPanel.add(transferPanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        transferPanel.setBackground(Color.PINK);
        bottomPanel.setBackground(Color.BLACK);

        // Setup text area for listing monkeys
        listTextArea = new JTextArea(10, 50);
        listTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listTextArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Set the main panel as the main content of the frame
        setContentPane(mainPanel);
    }

    /**
     * Creates the registration panel for new monkeys.
     *
     * @return JPanel the registration panel with input fields and a register button.
     */
    private JPanel createRegisterPanel() {
        // Main panel for registration
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BorderLayout());


        // Panel for input fields using Grid Layout
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 5)); // Added gaps for better spacing

        // Initialize input fields
        nameField = new JTextField(10);
        speciesBox = new JComboBox<>(Species.values());
        sexBox = new JComboBox<>(Sex.values());
        sizeField = new JTextField(10);
        weightField = new JTextField(10);
        ageField = new JTextField(10);
        foodBox = new JComboBox<>(Food.values());

        // Add components to input panel
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Sex:"));
        inputPanel.add(sexBox);
        inputPanel.add(new JLabel("Species:"));
        inputPanel.add(speciesBox);
        inputPanel.add(new JLabel("Favorite Food:"));
        inputPanel.add(foodBox);
        inputPanel.add(new JLabel("Size:"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);


        // Panel to hold the register button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registerButton = new JButton("Register");
        buttonPanel.add(registerButton);

        // Add the input panel and button panel to the main register panel
        registerPanel.add(inputPanel, BorderLayout.CENTER);
        registerPanel.add(buttonPanel, BorderLayout.SOUTH);

        return registerPanel;
    }

    /**
     * Creates the transfer panel for moving monkeys from isolation to an enclosure.
     *
     * @return JPanel the transfer panel with a monkey selection box and a transfer button.
     */
    private JPanel createTransferPanel() {
        JPanel transferPanel = new JPanel(new FlowLayout());
        isolationMonkeys = new JComboBox<>();
        transferButton = new JButton("Transfer");

        transferPanel.add(new JLabel("Select a Monkey from Isolation Cage Transferring to its Enclosure:"));
        transferPanel.add(isolationMonkeys);
        transferPanel.add(transferButton);

        return transferPanel;
    }

    /**
     * Creates the bottom panel containing buttons for displaying enclosures and an alphabetical list of monkeys.
     *
     * @return JPanel the bottom panel with action buttons.
     */
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        showAllEnclosuresButton = new JButton("Show Enclosure Details");
        showAllMonkeysButton = new JButton("Show Alphabetical List");
        bottomPanel.add(showAllEnclosuresButton);
        bottomPanel.add(showAllMonkeysButton);
        return bottomPanel;
    }

    // Additional 2 methods to add action listeners to buttons
    public void addShowAllEnclosuresButtonListener(ActionListener listener) {
        showAllEnclosuresButton.addActionListener(listener);
    }

    public void addShowAllMonkeysButtonListener(ActionListener listener) {
        showAllMonkeysButton.addActionListener(listener);
    }

    // Standard getter methods for all UI components
    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getTransferButton() {
        return transferButton;
    }

    public JButton getShowAllEnclosuresButton() {
        return showAllEnclosuresButton;
    }

    public JButton getShowAllMonkeysButton() {
        return showAllMonkeysButton;
    }

    public String getNameInput() {
        return nameField.getText();
    }

    public Species getSpeciesInput() {
        return (Species) speciesBox.getSelectedItem();
    }

    public Sex getSexInput() {
        return (Sex) sexBox.getSelectedItem();
    }

    public double getSizeInput() {
        return Double.parseDouble(sizeField.getText());
    }

    public double getWeightInput() {
        return Double.parseDouble(weightField.getText());
    }

    public int getAgeInput() {
        return Integer.parseInt(ageField.getText());
    }

    public Food getFoodInput() {
        return (Food) foodBox.getSelectedItem();
    }

    public Monkey getSelectedMonkeyFromIsolation() {
        return (Monkey) isolationMonkeys.getSelectedItem();
    }

    /**
     * Displays a message to the user in a dialog box.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Updates the text area with a list of monkeys by enclosures.
     *
     * @param data The string data to display in the list text area.
     */
    public void updateMonkeysList(String data) {
        StringBuilder formattedData = new StringBuilder();

        // Split the data into lines
        String[] lines = data.split("\\n");

        // Use a flag to identify when an enclosure has details
        boolean hasDetails = false;

        // Iterate through each line
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Check if it's an enclosure header line
            if (line.startsWith("Enclosure for species")) {
                // If the previous enclosure had no details, mark it as Empty
                if (!hasDetails && formattedData.length() > 0) {
                    formattedData.append("Empty\n\n");
                }
                // Always append the enclosure line, remove extra colon if present
                formattedData.append(line.replace("::", ":")).append("\n");
                // Reset the details flag for the next enclosure
                hasDetails = false;
            } else if (!line.isEmpty()) {
                // If there are details, append them and set the flag to true
                formattedData.append(line).append("\n");
                hasDetails = true;
            }
        }

        // Check the last enclosure in the loop
        if (!hasDetails && formattedData.length() > 0) {
            formattedData.append("Empty\n\n");
        }

        // Update the text area with the formatted data
        listTextArea.setText(formattedData.toString().trim()); // Trim to remove last newline characters
    }

    /**
     * Refreshes the list of monkeys in the isolation JComboBox with the provided array of monkeys.
     *
     * @param monkeys An array of Monkey objects to populate the isolation list.
     */
    public void refreshIsolationList(Monkey[] monkeys) {
        isolationMonkeys.removeAllItems();
        for (Monkey monkey : monkeys) {
            isolationMonkeys.addItem(monkey);
        }
    }

}
