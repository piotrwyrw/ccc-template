package ccc;

import ccc.levels.Level1;
import ccc.levels.SampleLevel;

public class Main {

    public static void main(String[] args) {
        Levels.invoke(Level1.class, "level_1");
    }

}
