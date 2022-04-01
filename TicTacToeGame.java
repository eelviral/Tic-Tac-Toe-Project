/*  Name: Chess Program
* Author: Eddie Elvira (@eelviral)
* Github_Page: https://www.github.com/eelviral/
* Created_On: Friday, December 3, 2021 at 04:20 UTC
 */

/**
 * The class implemented to start a new TicTacToe game
 */
public class TicTacToeGame {
    private static int xScore = 0;
    private static int oScore = 0;

    /**
     * The main method used to run the tictactoe game
     * 
     * @param args - no support for command-line arguments in this program
     */
    public static void main(String[] args) {
        startGame();
    }

    /**
     * Method used to begin the tictactoe game or start a new round
     */
    static void startGame() {
        new TicTacToeFrame();
    }

    /**
     * The getter method used to track number of times player X won
     * 
     * @return - player X wins
     */
    public static int getScoreX() {
        return xScore;
    }

    /**
     * The getter method used to track number of times player O won
     * 
     * @return - player O wins
     */
    public static int getScoreO() {
        return oScore;
    }

    /**
     * The method used to increment player X's score after each victory
     */
    public static void incrementScoreX() {
        xScore++;
    }

    /**
     * The method used to increment player O's score after each victory
     */
    public static void incrementScoreO() {
        oScore++;
    }
}