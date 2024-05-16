package aoc_2015;

import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Day3 {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        // hashcode wird mit x und y kombiniert um somit felder zu generieren
        @Override public int hashCode() { return Objects.hash(x, y); }
        // hier wird die vorsortierte  hashcode nochmal genauer sotiert
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
    public static void main(String[] args) throws IOException {
        String directions = new String(Files.readAllBytes(Paths.get("src/resources/CoordinatesDay3")),"UTF-8");
        Set<Point> visitedHouses = new HashSet<>();
        Point[] santaPositions = new Point[2];
        santaPositions[0] = new Point(0, 0); // Santa start position
        santaPositions[1] = new Point(0, 0); // Robo-Santa start position
        visitedHouses.add(new Point(0 ,0)); // Adding the starting house

        int turn = 0;
        for (char direction : directions.toCharArray()) {
            switch (direction) {
                case '^': santaPositions[turn].y--; break;
                case 'v': santaPositions[turn].y++; break;
                case '<': santaPositions[turn].x--; break;
                case '>': santaPositions[turn].x++; break;
            }
            visitedHouses.add(new Point(santaPositions[turn].x, santaPositions[turn].y));
            turn ^= 1; // Alternating between 0 and 1 for Santa and Robo-Santa turns
        }

        System.out.println("Number of houses that receive at least one present: " + visitedHouses.size());
    }
}


