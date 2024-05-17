package aoc_2015;

import java.util.*;
import java.nio.file.*;

public class Day7 {
    Map<String, String> instructions = new HashMap<>();
    Map<String, Integer> values = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Day7 d = new Day7();
        d.processFile("src/resources/Day7Wire");
        int signalA = d.getValue("a");
        System.out.println("Initial signal on wire a: " + signalA);
        d.values.clear();
        d.values.put("b", signalA);
        int newSignalA = d.getValue("a");
        System.out.println("New signal on wire a: " + newSignalA);
    }

    void processFile(String filename) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            String[] parts = line.split(" -> ");
            instructions.put(parts[1], parts[0]);
        }
    }

    int getValue(String wire) {

        // Check if the wire is already present in the map
        if (values.containsKey(wire)) {
            return values.get(wire);
        }

        // In case of numeric values
        try {
            return Integer.parseInt(wire);
        }catch (NumberFormatException e){
            String instruct = instructions.get(wire);
            int result;

            if (instruct.contains("AND")) {
                String[] parts = instruct.split(" AND ");
                result = getValue(parts[0]) & getValue(parts[1]);
            } else if (instruct.contains("OR")) {
                String[] parts = instruct.split(" OR ");
                result = getValue(parts[0]) | getValue(parts[1]);
            } else if (instruct.contains("LSHIFT")) {
                String[] parts = instruct.split(" LSHIFT ");
                result = getValue(parts[0]) << Integer.parseInt(parts[1]);
            } else if (instruct.contains("RSHIFT")) {
                String[] parts = instruct.split(" RSHIFT ");
                result = getValue(parts[0]) >> Integer.parseInt(parts[1]);
            } else if (instruct.contains("NOT")) {
                result = ~getValue(instruct.substring(4));
            } else {
                result = getValue(instruct);
            }
            result = result & 0xffff;
            values.put(wire, result);
            return result;
        }
    }
}