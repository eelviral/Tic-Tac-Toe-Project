import java.awt.event.*;

/**
 * The class implemented to detect button clicks and respond to them
 */
public class TicTacButtonListener implements ActionListener {
    TicTacToeScorePanel m_score;

    /**
     * The constructor for the button listener
     */
    TicTacButtonListener(TicTacToeScorePanel parent) {
        m_score = parent;
    }

    /**
     * The method which executes whenever it detects a button press
     * 
     * @param arg0 - data returned from ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        TicTacToeButton tButton = (TicTacToeButton) arg0.getSource(); // Check if a button was pressed

        boolean player1 = TicTacToePanel.getPlayer(); // Player 1 -> true, Player 2 -> false
        int pointVal = (int) tButton.getClientProperty("buttonPoints"); // Get the value of the current button
        int row = (int) tButton.getClientProperty("row"); // Get button's row position
        int col = (int) tButton.getClientProperty("column"); // Get button's column position

        if (!tButton.getState()) { // If the button is empty, continue
            if (player1) {
                tButton.setIconImage('x'); // Set button image to 'X'
                TicTacToePanel.setPlayer(false); // Player 2 goes next
                m_score.setPointsX(pointVal, row, col); // Add value to X
            }

            else {
                tButton.setIconImage('o'); // Set button image to 'O'
                TicTacToePanel.setPlayer(true); // Player 1 goes next
                m_score.setPointsO(pointVal, row, col); // Add value to O

            }
            tButton.setState(true); // Prevent button from being changed
            tButton.removeActionListener(this); // Stop reading any more clicks
        }

        if (checkButtons()) {
            tButton.sendResetSignal(); // Reset game if theres a win or tie
        }
    }

    /**
     * The method used to check if player X or O won, after it
     * detects that at least 3 clicks were made by one of them
     * 
     * @return - true if theres a winner or its a tie, false if
     *         the game is not over yet
     */
    boolean checkButtons() {
        int buttonClicks = m_score.getButtonClicks();

        if (buttonClicks > 4) {
            int winner = m_score.checkWinner();

            if (winner == 1) {
                System.out.println("Player X won!\n");
                TicTacToeGame.incrementScoreX();
                return true;
            } else if (winner == 2) {
                System.out.println("Player O won!\n");
                TicTacToeGame.incrementScoreO();
                return true;
            } else if (winner == 0 && buttonClicks >= 9) {
                System.out.println("It's a tie!\n");
                return true;
            }
        }
        return false;
    }
}