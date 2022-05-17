package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.Collections;
import java.util.List;

public class R2 extends DroidImpl implements Droid {
    private String name;

    public R2(String name) {
        // TODO: Complete this method
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return "Lifting " + item + " using sockets";
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
        return "Counted " + count + " " + wanted; // TODO: Make this String meaningful
    }

    @Override
    public String useTransporter() {
        return "Using R2-compatible transporter"; // TODO: Make this String meaningful
    }

    @Override
    public String useCrane() {
        return "Using R2-compatible crane"; // TODO: Make this String meaningful
    }

    @Override
    public String getName() {
        return name; // TODO: Make this String meaningful
    }

}
