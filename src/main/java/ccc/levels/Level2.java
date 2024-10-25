package ccc.levels;

import ccc.LevelImpl;

public class Level2 extends LevelImpl {
    @Override
    public String perform(String input) {
        String returnValue = "";
        String[] a = input.split("\n");
        for (int i = 1; i < a.length; i ++) {
            int velocity = 0;
            String s = a[i];
            int height = 0;
            String[] b = s.split("\\s+");
            for (String s2 : b) {
                velocity += Integer.parseInt(s2) - 10;
                height += velocity;
            }
            returnValue += height + "\n";
        }
        return returnValue;
    }
}
