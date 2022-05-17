package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;

import java.util.List;

public class FluidsAdapter implements Droid {
    private Fluids fluid;

    public FluidsAdapter(Fluids fluid) {
        this.fluid = fluid;
    }

    @Override
    public String liftItem(String item) {
        return fluid.pushItem(item, Direction.Up);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        String binaryCount = fluid.splitBy(inventory, item);
        int count = Integer.parseInt(binaryCount, 2);

        return "Fluid counted " + count + " " + item + ". " + fluid.merge();
    }

    @Override
    public String useTransporter() {
        return fluid.shapeShift(Shape.Transporter);
    }

    @Override
    public String useCrane() {
        return fluid.shapeShift(Shape.Crane);
    }

    @Override
    public String getName() {
        return fluid.getName();
    }

    @Override
    public String getType() {
        return "Adapted Fluids";
    }
}
