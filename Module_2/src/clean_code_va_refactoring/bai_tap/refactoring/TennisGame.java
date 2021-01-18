package clean_code_va_refactoring.bai_tap.refactoring;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        final int MAXIMUM = 4;
        if (player1Score==player2Score)
        {
            score = howToCall(player1Score);
            if(player1Score>=0&&player1Score<=3){
                score+="-All";
            }
        } else if (player1Score>=MAXIMUM || player2Score>=MAXIMUM){
            int minusResult = player1Score-player2Score;
            if (minusResult==1) {
                score += "Advantage player1";
            }
            else if (minusResult ==-1) {
                score += "Advantage player2";
            }
            else if (minusResult>=2) {
                score += "Win for player1";
            }
            else {
                score += "Win for player2";
            }
        } else{
            score += howToCall(player1Score) + "-" + howToCall(player2Score);
        }
        return score;
    }

    public static String howToCall(int number) {
        switch (number) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
}
