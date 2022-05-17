package id.ac.ui.cs.advancedprogramming.inventory.repository;

import id.ac.ui.cs.advancedprogramming.inventory.core.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyStorage {
    final private List<Dummy> dummies;

    public DummyStorage() { dummies = new ArrayList<>(); }

    public List<Dummy> getDummies() { return dummies; }

    public void createDummy(float weight, DummyType type, String weapon) {
        // TODO: Complete Me
        switch (type) {
            case MELEE:
                Dummy meleeDummy = new MeleeDummy(weight, weapon);
                meleeDummy.qualityCheck();
                dummies.add(meleeDummy);
                break;
            case RANGED:
                Dummy rangedDummy = new RangedDummy(weight, weapon);
                rangedDummy.qualityCheck();
                dummies.add(rangedDummy);
                break;
            case MAGIC:
                Dummy magicDummy = new MagicDummy(weight, weapon);
                magicDummy.qualityCheck();
                dummies.add(magicDummy);
                break;
        }
    }

    public void removeDummy(int index) {
        dummies.remove(index);
    }

    public Dummy getDummy(int index) {
        return dummies.get(index);
    }
}
