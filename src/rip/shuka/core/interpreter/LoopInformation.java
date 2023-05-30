package rip.shuka.core.interpreter;

public class LoopInformation {
    public int times;
    public String[] lines;
    public boolean isLooping = false;

    public LoopInformation(int times, String[] lines) {
        this.times = times;
        this.lines = lines;
    }

    public int getTimes() {
        return times;
    }

    public String[] getLines() {
        return lines;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }
}
