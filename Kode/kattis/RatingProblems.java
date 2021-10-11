package kattis;

import java.util.Scanner;

public class RatingProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalJudges = scanner.nextInt();
        int doneJudges = scanner.nextInt();

        double minScore = 0;
        double maxScore = 0;

        for (int i=0; i < doneJudges; i++) {
            int score = scanner.nextInt();
            minScore += score;
            maxScore += score;
        }
        minScore += (-3*(totalJudges-doneJudges));
        maxScore += (3*(totalJudges-doneJudges));
        System.out.println(minScore/totalJudges+" "+maxScore/totalJudges);
    }
}
