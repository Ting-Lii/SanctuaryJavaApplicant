package sanctuary;

import primates.Monkey;
import primates.Species;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Comparator;

/**
 * Mock implementation of the ISanctuaryModel for testing purposes.
 * This mock class does not perform real operations but simulates
 * the behavior of the SanctuaryModel by logging calls and returning
 * predefined responses.
 */
public class MockSanctuaryModel implements ISanctuaryModel {

    private final StringBuilder log = new StringBuilder();
    private final List<Monkey> mockIsolationList = new ArrayList<>();
    private final TreeMap<Species, List<Monkey>> mockEnclosures = new TreeMap<>();
    private boolean addMonkeyToIsolationResult = true;
    private boolean moveMonkeyToEnclosureResult = true;

    /**
     * Logs the addition attempt and returns a predetermined result.
     */
    @Override
    public boolean addMonkeyToIsolation(Monkey monkey) {
        log.append("addMonkeyToIsolation called with: ").append(monkey).append("\n");
        mockIsolationList.add(monkey);
        return addMonkeyToIsolationResult;
    }

    /**
     * Logs the transfer attempt and returns a predetermined result.
     */
    @Override
    public boolean moveMonkeyToEnclosure(Monkey monkey) {
        log.append("moveMonkeyToEnclosure called with: ").append(monkey).append("\n");
        // For simplicity, add the monkey to the mock enclosure directly if the result is true.
        if (moveMonkeyToEnclosureResult) {
            mockEnclosures.computeIfAbsent(monkey.getSpecies(), k -> new ArrayList<>()).add(monkey);
        }
        return moveMonkeyToEnclosureResult;
    }


    /**
     * Provides a simple string representation of the mock enclosures details.
     */
    @Override
    public List<String> listMonkeysInAllEnclosures() {
        log.append("listMonkeysInAllEnclosures called").append("\n");
        List<String> details = new ArrayList<>();
        mockEnclosures.forEach((species, monkeys) -> {
            details.add(species.toString() + ": " + monkeys);
        });
        return details;
    }

    /**
     * Returns a list of all monkeys, combining those from isolation and enclosures.
     */
    @Override
    public List<Monkey> listAllMonkeys() {
        log.append("listAllMonkeys called").append("\n");
        List<Monkey> allMonkeys = new ArrayList<>(mockIsolationList);
        mockEnclosures.values().forEach(allMonkeys::addAll);
        allMonkeys.sort(Comparator.comparing(Monkey::getName));
        return allMonkeys;
    }

    /**
     * Returns a list of all monkeys currently in mock isolation.
     */
    @Override
    public List<Monkey> listAllMonkeysInIsolation() {
        log.append("listAllMonkeysInIsolation called").append("\n");
        return new ArrayList<>(mockIsolationList);
    }

    /**
     * Retrieves the log of all actions called on this mock.
     *
     * @return A string representation of the log.
     */
    public String getLog() {
        return log.toString();
    }

    /**
     * Sets the predetermined result for the addMonkeyToIsolation method.
     *
     * @param result The result to return when addMonkeyToIsolation is called.
     */
    public void setAddMonkeyToIsolationResult(boolean result) {
        this.addMonkeyToIsolationResult = result;
    }

    /**
     * Sets the predetermined result for the moveMonkeyToEnclosure method.
     *
     * @param result The result to return when moveMonkeyToEnclosure is called.
     */
    public void setMoveMonkeyToEnclosureResult(boolean result) {
        this.moveMonkeyToEnclosureResult = result;
    }
}
