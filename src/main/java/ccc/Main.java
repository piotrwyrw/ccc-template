package ccc;

import ccc.levels.Level2;
import ccc.levels.Level3;

public class Main {

    public static void main(String[] args) {
        Levels.invoke(Level3.class, "level_3");
    }

}
