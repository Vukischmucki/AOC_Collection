package aoc_2015;

import java.io.*;
import java.util.*;


public class Day2 {
    public static void main(String[] args) {
        try {
            List<int[]> presents = readDimensions("src/resources/PackageDay2");
            int totalArea = calculateTotalArea(presents);
            System.out.println(totalArea + " square feet of wrapping paper should they order");

            int totalRibbon = calculateTotalRibbon(presents);
            System.out.println(totalRibbon + " feet of ribbon should they order");
        }  catch (IOException e) {
        e.printStackTrace();
     }
    }

    public static int calculateTotalArea(List<int[]> presents) {
        int totalArea = 0;
        for (int[] present : presents) {
            int l = present[0];
            int w = present[1];
            int h = present[2];
            int side1 = l * w;
            int side2 = w * h;
            int side3 = h * l;
            int extra = Math.min(Math.min(side1, side2), side3);
            totalArea += 2 * side1 + 2 * side2 + 2 * side3 + extra;
        }
        return totalArea;
    }

    public static List<int[]> readDimensions(String filepath) throws IOException {
        List<int[]> dimensions = new ArrayList<>();
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] dimension = scanner.nextLine().split("x");
            int l = Integer.parseInt(dimension[0]);
            int w = Integer.parseInt(dimension[1]);
            int h = Integer.parseInt(dimension[2]);
            dimensions.add(new int[]{l, w, h});
        }
        scanner.close();
        return dimensions;
    }

    public static int calculateTotalRibbon(List<int[]> presents) {
        int totalRibbon = 0;
        for (int[] present : presents) {
            int l = present[0];
            int w = present[1];
            int h = present[2];
            int side1 = l + w;
            int side2 = w + h;
            int side3 = h + l;
            int smallestPerimeter = Math.min(Math.min(side1, side2), side3) * 2; // x2 because each side needs twice as much ribbon (for two edges)            int bow = l * w * h;
            int bow = l * w * h;
            totalRibbon += smallestPerimeter + bow;
        }
        return totalRibbon;

    }
}





