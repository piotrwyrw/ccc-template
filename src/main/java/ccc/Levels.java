package ccc;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * A utility that runs all inputs for a given CCC level implementation and stored it in an outputs dir
 */
public class Levels {

    public static Map<File, String> invoke(Class<? extends LevelImpl> level, String path) {
        var map = new HashMap<File, String>();
        Instant start = Instant.now();
        File directory = new File("levels", path);
        if (!directory.exists()) {
            System.out.println("Could not run '" + level.getSimpleName() + "' - The inputs folder 'levels/" + path + "' does not exist.");
            return map;
        }
        if (!directory.isDirectory()) {
            System.out.println("Could not run '" + level.getSimpleName() + "' - The inputs path 'levels/" + path + "' is not a directory.");
            return map;
        }
        File[] inputs = directory.listFiles();
        assert inputs != null;
        LevelImpl instance;
        try {
            instance = level.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            System.out.println("Could not instantiate level '" + level.getSimpleName() + "' because of '" + e.getClass().getSimpleName() + "'");
            return map;
        }
        for (File input : inputs) {
            String fileName = input.getName();
            String inputString;
            try {
                inputString = Files.readString(input.toPath());
            } catch (IOException e) {
                System.out.println("Running level '" + level.getSimpleName() + "' failed because of " + e.getClass().getSimpleName() + " on '" + input.getPath() + "'");
                return new HashMap<>();
            }
            File outputDir = new File("outputs/levels/" + path);
            outputDir.mkdirs();
            File outputFile = new File(outputDir, fileName);
            String outputString = instance.perform(inputString);
            try {
                Files.writeString(outputFile.toPath(), outputString, StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println("Could not write output of level '" + level.getSimpleName() + "' file '" + fileName + "' because of '" + e.getClass().getSimpleName() + "'");
                return new HashMap<>();
            }
            System.out.println("[OK] " + level.getSimpleName() + " :: " + fileName);
            map.put(input, outputString);
        }
        Instant end = Instant.now();
        System.out.println("-- Level '" + level.getSimpleName() + "' completed in " + (end.toEpochMilli() - start.toEpochMilli()) + "ms --");
        return map;
    }
}
