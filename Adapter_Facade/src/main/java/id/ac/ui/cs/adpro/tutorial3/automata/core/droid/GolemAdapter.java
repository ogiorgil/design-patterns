package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;

import java.util.List;

public class GolemAdapter implements Droid {
    private Golem golem;

    public GolemAdapter(Golem golem) {
        this.golem = golem;
    }

    @Override
    public String liftItem(String item) {
        return golem.liftItem(item);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        int count = 0;
        for (String s: inventory) {
            if (golem.isItem(s, item).equals(String.format("item %s is %s", s, s))) {
                count++;
            }
        }
        return "Golem counted " + count + " " + item;
    }

    @Override
    public String useTransporter() {
        return golem.toss("item");
    }

    @Override
    public String useCrane() {
        return golem.punch(Punchable.CraneLever);
    }

    @Override
    public String getName() {
        return golem.getName();
    }

    @Override
    public String getType() {
        return "Adapted Golem";
    }
}
