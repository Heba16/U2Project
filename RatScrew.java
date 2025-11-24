import java.util.Random;
public class RatScrew {

    private static String robotCardChosen;
    private static String userCardChosen;
    private static String answer;
    private static int points = 0;

    public static void onePlay(){
        Random random = new Random();

        String[] possibleCards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
            for (int i = 0; i < 2; i++) {
                if (i % 2 == 0) {
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
        String[] faceCards = {"Jack", "King", "Queen"};
        boolean robotFaceCard = false;
        boolean userFaceCard = false;
        for (int i = 0; i < 3; i++) {
            if (robotCardChosen.equals(faceCards[i])) {
                robotFaceCard = true;
            }
            if (userCardChosen.equals(faceCards[i])) {
                userFaceCard = true;
            }
        }

        if (robotCardChosen.equals(userCardChosen)) {
            answer = "Pair";
        } else if (robotCardChosen.equals("Jack") || userCardChosen.equals("Jack")) {
            answer = "Jack";
        } else if (robotCardChosen.equals("King") && userCardChosen.equals("Queen") || robotCardChosen.equals("Queen") && userCardChosen.equals("King")) {
            answer = "Marriage";
        } else if (!robotFaceCard && !userFaceCard){
            if (robotCardChosen.equals("Ace")){
                robotCardChosen = "1";
            } else if (userCardChosen.equals("Ace")){
                userCardChosen = "1";
            }
            if (Integer.parseInt(robotCardChosen) + Integer.parseInt(userCardChosen) == 7){
                answer = "7";
            } else if (Integer.parseInt(robotCardChosen) + Integer.parseInt(userCardChosen) == 10){
                answer = "10";
            } else if (Integer.parseInt(robotCardChosen) == Integer.parseInt(userCardChosen) - 1 || Integer.parseInt(userCardChosen) == Integer.parseInt(robotCardChosen) - 1){
                answer = "Level";
            } else{
                answer = "None";
            }
        } else if (robotFaceCard && !userFaceCard){
            if (userCardChosen.equals("Ace")){
                userCardChosen = "1";
            }
            if(Integer.parseInt(userCardChosen) <= 5) {
                answer = "Subject";
            } else{
                answer = "Citizen";
            }
        } else if (!robotFaceCard && userFaceCard) {
            if (robotCardChosen.equals("Ace")){
                robotCardChosen = "1";
            }
            if (Integer.parseInt(robotCardChosen) <= 5) {
                answer = "Subject";
            } else {
                answer = "Citizen";
            }
        } else{
            answer = "None";
        }


    }

    public static void correctAnswer(String userAnswer){
        if (userAnswer.equals(answer)){
            points++;
            System.out.println("yes");
        }
    }

    public static void printPoints(int numberOfPlays){
        System.out.println("Points earned: " + points + "/" + numberOfPlays);
    }

    public static void printInstructions(){
        System.out.println("");
    }
}
