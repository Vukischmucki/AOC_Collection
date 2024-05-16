package aoc_2015.Day6Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    int[][] grid = new int[SIZE][SIZE];
    private static final int SIZE = 1000;

    public static void main(String[] args) {
        int[][] grid = new int[SIZE][SIZE];
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/resources/LightDay6"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                new LightInstruction(line).apply(grid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalBrightness = 0;
        for (int[] row : grid) {
            for (int light : row) {
                totalBrightness += light;
            }
        }
        System.out.println(totalBrightness);
    }
}