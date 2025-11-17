public class CardGame {
    public static void cardPlay(){
        String card = "";
        String play = "";
        int randomNum = (int) (Math.random() * 54) + 1;
        for (int i = 0; i < 54; i++){
            if (i % 2 == 0){
                card = "my number: " + String.valueOf(i);
                System.out.println(randomNum);
            } else {
                card = "your number: " + String.valueOf(i);
                System.out.println(randomNum);
            }
        }
    }
    public static String randomCard(){
        int randomNum = (int) (Math.random() * 54) + 1;
        String[] numbers = {"King", "Queen", "Joker", 40, 50};
    }
}
