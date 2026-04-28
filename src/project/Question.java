package project;

public class Question {
    String question;
    String[] options;
    int correct;

    Question(String q, String[] opt, int ans) {
        question = q;
        options = opt;
        correct = ans;
    }
}