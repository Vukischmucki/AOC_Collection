package aoc_2015;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day8 {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/resources/Day8Puzzleinput"));
            System.out.println("Part 1 solution: " + calculateDifference(lines));
            System.out.println("Part 2 solution: " + calculateDifferenceBetweenEncodedAndOriginalCharacters(lines));
        } catch (Exception e) {
            System.out.println("Fehler beim Lesen der Datei " + e.getMessage());
        }
    }

    public static int calculateDifference(List<String> lines) {
        int totalCodeCharacters = 0;
        int totalMemoryCharacters = 0;

        for (String line : lines) {
            totalCodeCharacters += line.length();
            totalMemoryCharacters += line.replaceAll("\\\\\"", "\"")
                    .replaceAll("\\\\\\\\", "\\\\")
                    .replaceAll("\\\\x[0-9a-fA-F]{2}", "0")
                    .length() - 2;  // Subtract 2 for the leading and trailing quotes that are not part of the in-memory string
        }
        return totalCodeCharacters - totalMemoryCharacters;
    }

    public static int calculateDifferenceBetweenEncodedAndOriginalCharacters(List<String> lines) {
        int totalOriginalCharacters = 0;
        int totalEncodedCharacters = 0;

        for (String line : lines) {
            totalOriginalCharacters += line.length();
            String encodedLine = "\"" + line
                    .replaceAll("\\\\", "\\\\\\\\")
                    .replaceAll("\"", "\\\\\\\"")
                    + "\"";
            totalEncodedCharacters += encodedLine.length();
        }

        return totalEncodedCharacters - totalOriginalCharacters;
    }
}