package id.ac.ui.cs.adpro.tutorial3.automata.service;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;

import java.util.*;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.FluidsAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.GolemAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroidServiceImpl implements DroidService {

    @Autowired
    private DroidRepository droidRepository;

    @Autowired
    private FluidsRepository fluidsRepository;

    @Autowired
    private GolemRepository golemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private LoggerRepository loggerRepository;

    private List<Droid> units;

    private int unitCount = 1; // 1 to conform with DroidServiceTest.java

    private Set<String> uniqueInventory;

    private Set<String> getUniqueInventory() {
        if (uniqueInventory == null) {
            uniqueInventory = new HashSet<>(fetchInventories());
        }
        return uniqueInventory;
    }

    /**
     * Mengambil seluruh droid yang tersimpan.
     * Note: Termasuk seluruh automata pengganti droid.
     *
     * @return List automata
     */
    @Override
    public List<Droid> fetchDroids() {
        // TODO: Complete this method
        if (units != null && units.size() == unitCount) {
            return units;
        }
        units = new ArrayList<>(droidRepository.findAll());
        for (Fluids fluid: fluidsRepository.findAll()) {
            units.add(new FluidsAdapter(fluid));
        }
        for (Golem golem: golemRepository.findAll()) {
            units.add(new GolemAdapter(golem));
        }
        unitCount = units.size();
        return units;
    }

    /**
     * Mengambil seluruh rekaman inventory yang tersimpan.
     *
     * @return List rekaman inventory
     */
    @Override
    public List<String> fetchInventories() {
        // TODO: Complete this method
        return inventoryRepository.fetchInventory();
    }

    /**
     * Menambahkan sebuah benda ke dalam inventory.
     *
     * @param item benda untuk ditambah
     */
    @Override
    public void addInventory(String item) {
        // TODO: Complete this method
        inventoryRepository.addItem(item);
        getUniqueInventory().add(item);
    }

    /**
     * Mengambil seluruh rekaman log yang tersimpan.
     *
     * @return List rekaman log
     */
    @Override
    public List<String> fetchLogs() {
        // TODO: Complete this method
        return loggerRepository.getLogs();
    }

    private Droid getDroid(String droidName) {
        Droid found = null;
        for (Droid d: fetchDroids()) {
            if (d.getName().equals(droidName)) {
                found = d;
            }
        }
        return found;
    }

    /**
     * Memanggil droid untuk melakukan sebuah rutinitas.
     *
     * @param droidName droid yang ingin dipanggil
     * @param routine   rutinitas yang akan dilakukan droid
     */
    @Override
    public void doRoutine(String droidName, int routine) {
        // TODO: Complete this method
        Droid droid = getDroid(droidName);
        if (droid == null) {
            return;
        }
        switch (routine) {
            case 0:
                for (String item: fetchInventories()) {
                    recordLog(droid, droid.liftItem(item));
                }
                break;
            case 1:
                for (String item: getUniqueInventory()) {
                    recordLog(droid, droid.countItem(fetchInventories(), item));
                }
                break;
            case 2:
                recordLog(droid, droid.useTransporter());
                break;
            case 3:
                recordLog(droid, droid.useCrane());
                break;
            default:
        }
    }

    /**
     * Rekam sebuah Log dengan format: "<Nama droid>: <Aksi droid>"
     *
     * @param droid  Droid yang melakukan aksi
     * @param action Aksi yang dilakukan droid
     */
    protected void recordLog(Droid droid, String action) {
        // TODO: Complete this method
        loggerRepository.addRecord(droid.getName() + ": " + action);
    }
}
