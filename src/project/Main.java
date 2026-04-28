package project;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("      QUIZ APPLICATION (JAVA)        ");
        System.out.println("=====================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        User user = new User(name);
        Leaderboard lb = new Leaderboard();

        while (true) {
            System.out.println("\n-------------------------------------");
            System.out.println("1) Start Quiz");
            System.out.println("2) View Leaderboard");
            System.out.println("3) Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Quiz quiz = new Quiz();
                    int score = quiz.startQuiz();
                    lb.saveScore(user.name, score);
                    break;

                case 2:
                    lb.showLeaderboard();
                    break;

                case 3:
                    System.out.println("Exiting... धन्यवाद 🙏");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}