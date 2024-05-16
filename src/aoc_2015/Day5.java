package aoc_2015;

import java.nio.file.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) throws IOException {
        String[] naughtyList = Files.readAllLines(Paths.get("src/resources/NaughtyListDay5")).toArray(new String[0]);
        int niceCount = 0;

        for (String word : naughtyList) {
            if (isNice(word)) {
                niceCount++;
            }
        }

        System.out.println("Number of nice strings: " + niceCount);
    }

    static boolean isNice(String word) {
        Matcher matcher1 = Pattern.compile("([a-z]{2}).*\\1").matcher(word);
        Matcher matcher2 = Pattern.compile("([a-z]).\\1").matcher(word);

        return matcher1.find() && matcher2.find();
    }
}