import javax.swing.JPanel;

import java.awt.*;

/**
 * The class implemented to set up the button panel
 */
public class TicTacToePanel extends JPanel {
    TicTacToeButton[][] m_buttons;
    TicTacToeFrame m_parent;
    TicTacToeScorePanel m_ScorePanel;
    static boolean player1 = true; // Player X goes first

    // Used to find winner. Winning combinations equal 15, every time
    int[][] magic_square = {
            { 8, 1, 6 },
            { 3, 5, 7 },
            { 4, 9, 2 }
    };

    /**
     * The constructor of the tictactoe panel
     */
    TicTacToePanel(TicTacToeFrame parent, TicTacToeScorePanel scorePanel) {
        m_parent = parent;
        setLayout(new GridLayout(3, 3, 10, 10));
        m_buttons = new TicTacToeButton[3][3];
        m_ScorePanel = scorePanel;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Create buttons
                m_buttons[i][j] = new TicTacToeButton(this);

                m_buttons[i][j].putClientProperty("buttonPoints", magic_square[i][j]);
                m_buttons[i][j].putClientProperty("row", i);
                m_buttons[i][j].putClientProperty("column", j);

                // Add button click detection and response to buttons
                m_buttons[i][j].addActionListener(new TicTacButtonListener(m_ScorePanel));
                add(m_buttons[i][j]);
            }
        }
    }

    /**
     * The method that sends a reset signal to the TicTacToeFrame parent class
     * if TicTacToeButton sends the same signal from the button listener
     */
    void resetFrame() {
        m_parent.reset();
    }

    /**
     * The getter method which returns the current player turn
     * 
     * @return - player turn (true for X, false for O)
     */
    static boolean getPlayer() {
        return player1;
    }

    /**
     * The setter method which changes the next player turn
     * 
     * @param player - player turn (true for X, false for O)
     */
    static void setPlayer(boolean player) {
        player1 = player;
    }
}