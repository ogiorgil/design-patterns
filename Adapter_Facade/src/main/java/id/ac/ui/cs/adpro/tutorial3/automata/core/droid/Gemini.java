package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.Collections;
import java.util.List;

public class Gemini extends DroidImpl implements Droid {
    private String name;

    public Gemini(String name) {
        // TODO: Complete this method
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return "Lifting " + item + " with mechanical arms"; // TODO: Make this String meaningful
    }

    /**
     * Count numbers of wanted items inside inventory.
     *
     * @param inventory collection of items
     * @param wanted    item to count
     * @return String that describes the count result.
     */
    @Override
    public String countItem(List<String> inventory, String wanted) {
        int count = Collections.frequency(inventory, wanted);
        return "Found " + count + " " + wanted; // TODO: Make this String meaningful
    }

    @Override
    public String useTransporter() {
        return "Using Gemini-compatible transporter"; // TODO: Make this String meaningful
    }

    @Override
    public String useCrane() {
        return "Using Gemini-compatible crane"; // TODO: Make this String meaningful
    }

    @Override
    public String getName() {
        return name; // TODO: Make this String meaningful
    }

}
