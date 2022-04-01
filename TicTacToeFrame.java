import javax.swing.JFrame;
import java.awt.*;

/**
 * The class implemented to create the tictactoe UI window
 */
public class TicTacToeFrame extends JFrame {
    TicTacToePanel tPanel;
    TicTacToeScorePanel tScorePanel;

    /**
     * The constructor for the tictactoe frame
     */
    public TicTacToeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLayout(new BorderLayout());
        setTitle("TicTacToe Game");
        tScorePanel = new TicTacToeScorePanel();
        tPanel = new TicTacToePanel(this, tScorePanel);
        getContentPane().add(tPanel, BorderLayout.CENTER);
        getContentPane().add(tScorePanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    /**
     * The method which hides and disposes of the current frame then calls
     * a static method in TicTacToeGame to replace it for a new round
     */
    void reset() {
        setVisible(false);
        dispose();
        TicTacToeGame.startGame();
    }
}