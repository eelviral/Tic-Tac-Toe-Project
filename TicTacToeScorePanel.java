import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class implemented to display the score
 */
public class TicTacToeScorePanel extends JPanel {
    int xScore = TicTacToeGame.getScoreX();
    int oScore = TicTacToeGame.getScoreO();

    int[] magic_squareX = { -15, -15, -15, -15, -15, -15, -15, -15, -15 };
    int[] magic_squareO = { -15, -15, -15, -15, -15, -15, -15, -15, -15 };
    int xPoints = 0;
    int oPoints = 0;
    int buttonClicks = 0;

    private JTextField m_scoreString;

    /**
     * The constructor for the score panel
     */
    public TicTacToeScorePanel() {
        m_scoreString = new JTextField();
        this.add(m_scoreString);
        setScoreString(xScore, oScore);
    }

    /**
     * The method to call with the two scores to display
     * 
     * @param xScore - the x player score
     * @param oScore - the o player score
     */
    public void setScoreString(int xScore, int oScore) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player X has " + xScore + " wins ");
        sb.append("Player O has " + oScore + " wins");
        m_scoreString.setText(sb.toString());
    }

    /**
     * The setter method that maps 2D magic square values to a 1D array.
     * Keeps track of player X's gathered points.
     * 
     * @param pointVal - value of the button clicked by player X
     * @param row      - row position of button clicked by player X in 2D magic
     *                 square
     * @param col      - column position of button clicked by player X in 2D magic
     *                 square
     */
    void setPointsX(int pointVal, int row, int col) {
        magic_squareX[3 * row + col] = pointVal;
        addButtonClick();
    }

    /**
     * The setter method that maps 2D magic square values to a 1D array.
     * Keeps track of player O's gathered points.
     * 
     * @param pointVal - value of the button clicked by player O
     * @param row      - row position of button clicked by player O in 2D magic
     *                 square
     * @param col      - column position of button clicked by player O in 2D magic
     *                 square
     */
    void setPointsO(int pointVal, int row, int col) {
        magic_squareO[3 * row + col] = pointVal;
        addButtonClick();
    }

    /**
     * The method which increments the number of button clicks by 1
     */
    void addButtonClick() {
        buttonClicks++;
    }

    /**
     * The getter method which keeps track of button clicks
     */
    int getButtonClicks() {
        return buttonClicks;
    }

    /**
     * The method which checks all 3-button combinations of 1D magic square arrays
     * to see if they add up to 15, which is the winning case
     * 
     * @return - 0 (No win was found), 1 (player X wins), 2 (player O wins)
     */
    int checkWinner() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (i != j && i != k && j != k) {
                        int totalX = magic_squareX[i] + magic_squareX[j] + magic_squareX[k];
                        int totalO = magic_squareO[i] + magic_squareO[j] + magic_squareO[k];
                        if (totalX == 15) {
                            return 1;
                        } else if (totalO == 15)
                            return 2;
                    }
                }
            }
        }
        return 0;
    }
}