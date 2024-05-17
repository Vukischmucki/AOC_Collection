package aoc_2015.Day6Light;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LightInstruction {
    private static final Pattern PATTERN = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");
    private final LightOperation op;
    private final int left, right, top, bottom;

    public LightInstruction(String s) {
        Matcher m = PATTERN.matcher(s);
        if (!m.matches()) throw new IllegalArgumentException("Invalid instruction: " + s);
        this.op = LightOperation.valueOf(m.group(1).replace(" ", "_").toUpperCase());
        this.left = Integer.parseInt(m.group(2));
        this.top = Integer.parseInt(m.group(3));
        this.right = Integer.parseInt(m.group(4));
        this.bottom = Integer.parseInt(m.group(5));
    }

    public void apply(int[][] grid) {
        for (int x = left; x <= right; x++)
            for (int y = top; y <= bottom; y++)
                grid[x][y] = op.apply(grid[x][y]);
    }

}