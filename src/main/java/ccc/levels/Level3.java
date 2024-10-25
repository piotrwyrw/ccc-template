package ccc.levels;

import ccc.LevelImpl;

public class Level3 extends LevelImpl {

    int counter = 0;

    @Override
    public String perform(String input) {
        StringBuilder returnValue = new StringBuilder();
        String[] a = input.split("\n");
        System.out.println("maximumTick: " + Integer.parseInt(a[1].replaceAll("\r", "")));
        for (int i = 2; i < a.length; i ++) {
            counter = 0;

            int targetHeight = Integer.parseInt(a[i].replaceAll("\r", ""));

            int height = 0;
            while (height < targetHeight) {
                int[] nextTwoTicks = nextTickAccHeight(targetHeight, height);

                height += nextTwoTicks[0] - 10;

                returnValue.append(nextTwoTicks[0]).append(" ").append(nextTwoTicks[1]).append(" ");
            }

            while (height > 0) {
                int[] nextTwoTicks = nextTickDeccHeight(targetHeight, height);

                height += nextTwoTicks[0] - 10;

                if (height < 2) {
                    height += (nextTwoTicks[0] - 10) + nextTwoTicks[1] - 10;
                }

                returnValue.append(nextTwoTicks[0]).append(" ").append(nextTwoTicks[1]);
                if (height != 0) {
                    returnValue.append(" ");
                }
            }
            returnValue.append("\n");
            System.out.println("Amount of ticks: " + Integer.toString(counter));
        }
        return returnValue.toString();

    }

    public int[] nextTickAccHeight(int targetHeight, int currentHeight) {
        int[] ticks = new int[2];
        if ((targetHeight - currentHeight) > 10) {
            ticks[0] = 20;
            ticks[1] = 0;
        }
        else {
            ticks[0] = targetHeight - currentHeight + 10;
            ticks[1] = (ticks[0] - 20) * (-1);
        }

        counter += 2;
        return ticks;
    }

    public int[] nextTickDeccHeight(int targetHeight, int currentHeight) {
        int[] ticks = new int[2];
        if (currentHeight > 10) {
            ticks[0] = 0;
            ticks[1] = 20;
        }
        if (currentHeight > 1 && currentHeight <= 10) {
            ticks[0] = 10 - (currentHeight - 1);
            ticks[1] = (ticks[0] - 19) * (-1);
        }
        counter += 2;
        return ticks;
    }
}
