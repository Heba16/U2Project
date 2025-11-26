import java.util.Random;
public class RatScrew {

    private static String robotCardChosen;
    private static String userCardChosen;
    private static String answer;
    private static int points = 0;

    public static void oneRound(){
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
        } else if (robotCardChosen.equals("Jack") && userCardChosen.equals("Queen") || robotCardChosen.equals("Queen") && userCardChosen.equals("Jack")) {
            answer = "Affair";
        }else if (robotCardChosen.equals("Jack") || userCardChosen.equals("Jack")) {
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
            } else if (Integer.parseInt(robotCardChosen) == Integer.parseInt(userCardChosen) - 1 || Integer.parseInt(userCardChosen) == Integer.parseInt(robotCardChosen) - 1) {
                answer = "Level";
            }else if (Integer.parseInt(robotCardChosen) + Integer.parseInt(userCardChosen) >= 12){
                answer = "High";
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
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    public static void printPoints(int numberOfRounds){
        System.out.println("Points earned: " + points + "/" + numberOfRounds);
    }

    public static void printInstructions(){
        System.out.println("Welcome to Heba's RatScrew! Here are the rules:");
        System.out.println("Every 2 random cards (a round) you will have to recognize and write down a pattern");
        System.out.println("Here are the patterns in precedence order:");
        System.out.println("Pair - If two cards are the same number or face");
        System.out.println("Affair - If a Queen and a Jack card are both played");
        System.out.println("Jack - If a Jack card is played");
        System.out.println("Marriage - If a Queen and a King card are both played");
        System.out.println("Subject - If a either a King or Queen are played with another card with a value less than or equal to 5");
        System.out.println("Citizen - If a either a King or Queen are played with another card with a value higher than 5");
        System.out.println("Level - If either of the two cards are one less than the other");
        System.out.println("7 - If the two cards add to 7");
        System.out.println("10 - If the two cards add to 10");
        System.out.println("High - If the two cards add to any number higher than or equal to 12");
        System.out.println("None - If none of the previous patterns are found");
        System.out.println();
    }
}
