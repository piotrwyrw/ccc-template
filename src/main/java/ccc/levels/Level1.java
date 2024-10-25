package ccc.levels;

import ccc.LevelImpl;

public class Level1 extends LevelImpl {
    @Override
    public String perform(String input) {
        String returnValue = "";
        String[] a = input.split("\n");
        for (String s : a) {
            int value = 0;
            String[] b = s.split(" ");
            for (String s2 : b) {
                value += Integer.parseInt(s2.replaceAll("\r", ""));
            }
            returnValue += value + "\n";
        }
        return returnValue;
    }
}
