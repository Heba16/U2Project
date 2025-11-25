import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RatScrew.printInstructions();
        Scanner scan = new Scanner(System.in);
        System.out.print("How many rounds do you want in this game?: ");
        int roundNumber = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < roundNumber; i++) {
            RatScrew.oneRound();
            System.out.print("Pattern: ");
            String answer = scan.nextLine();
            RatScrew.correctAnswer(answer);
        }
        RatScrew.printPoints(roundNumber);
    }
}
