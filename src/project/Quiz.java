package project;

import java.util.*;

public class Quiz {

    List<Question> questions = new ArrayList<>();

    Quiz() {
    	questions.add(new Question("Which of the following is not a primitive data type in Java?",
    	        new String[]{"int", "float", "String", "boolean"}, 3));

    	questions.add(new Question("Which collection does not allow duplicate elements?",
    	        new String[]{"List", "Set", "ArrayList", "LinkedList"}, 2));

    	questions.add(new Question("Which keyword is used to define a constant in Java?",
    	        new String[]{"const", "final", "static", "immutable"}, 2));

    	questions.add(new Question("Which of the following is used to create an object?",
    	        new String[]{"class", "new", "void", "object"}, 2));

    	questions.add(new Question("Which interface provides capability to store objects in key-value pairs?",
    	        new String[]{"List", "Set", "Map", "Queue"}, 3));
    }

    int startQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {

            System.out.println("\n-------------------------------------");
            System.out.println("Question: " + q.question);
            System.out.println("-------------------------------------");

            // Options
            int index[] = {1};
            Arrays.stream(q.options).forEach(opt -> {
                System.out.println((index[0]++) + ") " + opt);
            });

            int ans = -1;

            System.out.print("\nAnswer (20 sec): ");

            long start = System.currentTimeMillis();

            // 20 sec timer logic
            while ((System.currentTimeMillis() - start) < 20000) {

                try {
                    if (System.in.available() > 0) {
                        ans = sc.nextInt();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Time up
            if (ans == -1) {
                System.out.println("Time's up! Skipped!");
                continue;
            }

            // Answer check
            if (ans == q.correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        // Final Score
        System.out.println("\n=====================================");
        System.out.println("         QUIZ COMPLETED              ");
        System.out.println("=====================================");
        System.out.println("Your Final Score: " + score);

        return score;
    }
}