package ccc.levels;

import ccc.LevelImpl;

public class Level1 extends LevelImpl {
    @Override
    public String perform(String input) {
        String returnValue = "";
        String[] a = input.split("\n");
        for (int i = 1; i < a.length; i ++) {
            String s = a[i];
            int value = 0;
            String[] b = s.split("\\s+");
            for (String s2 : b) {
                value += Integer.parseInt(s2);

            }
            returnValue += value + "\n";
        }
        return returnValue;
    }
}
