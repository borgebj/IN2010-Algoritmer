import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();

        for (int i=0; i < lines; i++) {
            int b = scanner.nextInt();
            int p = scanner.nextInt();

            int bpm = (60*b)/p;
            int abpm = (60/p);
            System.out.println(bpm);
        }
    }
}
