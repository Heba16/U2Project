import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int playNumber = 5;
        for (int i = 0; i < playNumber; i++) {
            RatScrew.startPlay();
            System.out.print("Pattern: ");
            String answer = scan.nextLine();
            RatScrew.correctAnswer(answer);
        }
        RatScrew.printPoints(playNumber);
    }
}
