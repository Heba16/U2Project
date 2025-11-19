import java.util.Random;
public class RatScrew {

    private static String robotCardChosen;
    private static String userCardChosen;
    private static String answer;

    public static void startPlay(){
        Random random = new Random();

        String[] possibleCards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
        for(int i = 0; i < 2; i++){
            if (i % 2 == 0){
                System.out.print("robot's card: ");
                int randomCard = random.nextInt(possibleCards.length);
                robotCardChosen = possibleCards[randomCard];
                System.out.println(robotCardChosen);
            } else {
                System.out.print("your card: ");
                int randomCard2 = random.nextInt(possibleCards.length);
                userCardChosen = possibleCards[randomCard2];
                System.out.println(userCardChosen);
            }
        }
        analyzePlay();

    }

    public static void analyzePlay(){
        String[] faceCards = {"Ace", "Jack", "King", "Queen"};
        boolean faceCard = false;
        for (int i = 0; i < 4; i++){
            if (robotCardChosen.equals(faceCards[i]) || userCardChosen.equals(faceCards[i])){
                faceCard = true;

            }
        }

        if (robotCardChosen.equals(userCardChosen)) {
            answer = "Pair";
        } else if (robotCardChosen.equals("King") && userCardChosen.equals("Queen") || robotCardChosen.equals("Queen") && userCardChosen.equals("King")) {
            answer = "Marriage";
        } else if (!faceCard && Integer.valueOf(robotCardChosen) + Integer.valueOf(userCardChosen) == 7){
            answer = "7";
        } else {
            answer = "None";
        }


    }

    public static boolean correctAnswer(String userAnswer){
        if (userAnswer.equals(answer)){
            return true;
        } else {
            return false;
        }
    }
}
