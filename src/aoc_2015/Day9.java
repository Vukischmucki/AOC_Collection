package aoc_2015;

import java.util.*;

public class Day9 {
    private static final HashMap<String, Integer> dists = new HashMap<>();
    private static final ArrayList<String> locations = new ArrayList<>();

    public static void main(String[] args) {
        // Process the puzzle input
        String[] inputs = new String[]{
                "Faerun-Norrath=129",
                "Faerun-Tristram=58",
                "Faerun-AlphaCentauri=13",
                "Faerun-Arbre=24",
                "Faerun-Snowdin=60",
                "Faerun-Tambi=71",
                "Faerun-Straylight=67",
                "Norrath-Tristram=142",
                "Norrath-AlphaCentauri=15",
                "Norrath-Arbre=135",
                "Norrath-Snowdin=75",
                "Norrath-Tambi=82",
                "Norrath-Straylight=54",
                "Tristram-AlphaCentauri=118",
                "Tristram-Arbre=122",
                "Tristram-Snowdin=103",
                "Tristram-Tambi=49",
                "Tristram-Straylight=97",
                "AlphaCentauri-Arbre=116",
                "AlphaCentauri-Snowdin=12",
                "AlphaCentauri-Tambi=18",
                "AlphaCentauri-Straylight=91",
                "Arbre-Snowdin=129",
                "Arbre-Tambi=53",
                "Arbre-Straylight=40",
                "Snowdin-Tambi=15",
                "Snowdin-Straylight=99",
                "Tambi-Straylight=70"
        };

        for (String input: inputs) {
            String[] parts = input.split("=");
            dists.put(parts[0], Integer.parseInt(parts[1]));

            // Ensure both locations are added to the locations list
            String[] places = parts[0].split("-");
            if (!locations.contains(places[0])) {
                locations.add(places[0]);
            }
            if (!locations.contains(places[1])) {
                locations.add(places[1]);
            }

            // Add the reverse path
            dists.put(places[1] + "-" + places[0], Integer.parseInt(parts[1]));
        }

        // continue with the original code

        ArrayList<String> path = new ArrayList<>(locations);
        int shortestDist = Integer.MAX_VALUE;

        // Generate all permutations and test each.
        while (nextPermutation(path)) {
            int dist = pathDist(path);
            if (dist < shortestDist) {
                shortestDist = dist;
            }
        }

        System.out.println("Shortest Distance: " + shortestDist);
    }

    public static int pathDist(List<String> path) {
        int dist = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            dist += dists.get(path.get(i) + "-" + path.get(i+1));
        }

        return dist;
    }

    // Lexicographically next permutation
    public static boolean nextPermutation(List<String> array) {
        // Find longest non-increasing suffix
        int i = array.size() - 1;
        while (i > 0 && array.get(i - 1).compareTo(array.get(i)) >= 0) {
            i--;
        }
        // Check if the entire sequence is non-increasing
        if (i <= 0) {
            return false;
        }

        // Find the rightmost successor to pivot in the suffix
        int j = array.size() - 1;
        while (array.get(j).compareTo(array.get(i - 1)) <= 0) {
            j--;
        }
        // Swap pivot with its rightmost successor
        Collections.swap(array, i - 1, j);

        // Reverse the suffix
        Collections.reverse(array.subList(i, array.size()));

        return true;
    }
}