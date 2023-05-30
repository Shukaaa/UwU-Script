package rip.shuka.core.logic.incrementer;

import java.util.ArrayList;

public class IncrementerStore {
    private final static IncrementerStore instance = new IncrementerStore();
    private ArrayList<Incrementer> incrementers = new ArrayList<>();

    public static IncrementerStore getInstance() {
        return instance;
    }

    public void addIncrementer(Incrementer incrementer) {
        // Replace incrementer if it already exists
        for (int i = 0; i < incrementers.size(); i++) {
            if (incrementers.get(i).name().equals(incrementer.name())) {
                incrementers.add(i, incrementer);
                return;
            }
        }

        // Add incrementer if it doesn't exist
        incrementers.add(incrementer);
    }

    public Incrementer getIncrementer(String name) {
        for (Incrementer incrementer : incrementers) {
            if (incrementer.name().equals(name)) {
                return incrementer;
            }
        }
        return null;
    }
}
