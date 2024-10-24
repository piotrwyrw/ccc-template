package ccc.levels;

import ccc.LevelImpl;

public class SampleLevel extends LevelImpl {
    @Override
    public String perform(String input) {
        return input.toUpperCase();
    }
}
