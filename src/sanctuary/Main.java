package sanctuary;// Main.java

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create the model
        Sanctuary sanctuary = new Sanctuary();

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> {
            // Create the view
            SanctuaryView view = new SanctuaryView();

            // Create the controller
            SanctuaryController controller = new SanctuaryController(sanctuary, view);

            // Set the view visible (this also ensures that the GUI will be displayed after it's completely initialized)
            view.setVisible(true);
        });
    }
}
