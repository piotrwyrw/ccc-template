package ccc;

import ccc.levels.SampleLevel;

public class Main {

    public static void main(String[] args) {
        Levels.invoke(SampleLevel.class, "level_1");
    }

}
