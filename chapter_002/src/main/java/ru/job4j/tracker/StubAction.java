package ru.job4j.tracker;

public class StubAction implements UserAction {
    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
