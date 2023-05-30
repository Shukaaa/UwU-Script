package rip.shuka.core.logic.incrementer;

public class Incrementer {
    private final String name;
    private int value;

    public Incrementer(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public int value() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }
}
