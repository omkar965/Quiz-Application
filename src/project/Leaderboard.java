package project;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Leaderboard {

    // 🔹 Save score
    void saveScore(String name, int score) {
        try {
            FileWriter fw = new FileWriter("scores.txt", true);
            fw.write(name + " - " + score + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 Show leaderboard in table format (Top score first)
    void showLeaderboard() {
        System.out.println("\n=====================================");
        System.out.println("           LEADERBOARD               ");
        System.out.println("=====================================");

        // Table heading
        System.out.printf("\n%-15s | %s\n", "Name", "Score");
        System.out.println("-------------------------------");

        try {
            Files.lines(Paths.get("scores.txt"))
                .sorted((a, b) -> {
                    int s1 = Integer.parseInt(a.split("-")[1].trim());
                    int s2 = Integer.parseInt(b.split("-")[1].trim());
                    return s2 - s1; // 🔥 descending (top first)
                })
                .forEach(line -> {
                    String[] parts = line.split("-");
                    String name = parts[0].trim();
                    String score = parts[1].trim();

                    System.out.printf("%-15s | %s\n", name, score);
                });

        } catch (Exception e) {
            System.out.println("No data found.");
        }
    }
}