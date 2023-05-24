package rip.shuka.core.logic.arrays;

import java.util.ArrayList;

public class ArrayStore {
    private final static ArrayStore instance = new ArrayStore();
    private final ArrayList<Array> arrays = new ArrayList<>();

    private ArrayStore() { }

    public static ArrayStore getInstance() {
        return instance;
    }

    public void addArray(Array array) {
        arrays.add(array);
    }

    public Array getArray(String name) {
        for (Array array : arrays) {
            if (array.name().equals(name)) {
                return array;
            }
        }

        return null;
    }
}
