import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The class implemented to create a button for tictactoe
 */
public class TicTacToeButton extends JButton {
    ImageIcon m_image;
    TicTacToePanel m_panel;
    boolean m_state = false; // Set initial button state to unclicked

    File fx = new File("images\\X.png");
    File fo = new File("images\\O.png");

    /**
     * The constructor for the buttons
     */
    TicTacToeButton(TicTacToePanel parent) {
        m_panel = parent;
    }

    /**
     * The method which sets the image of a button to X or O, based on which player
     * clicked
     * 
     * @param icn - char 'x' if clicked by player X, or char 'o' if clicked by
     *            player O
     */
    void setIconImage(char icn) {
        Image ii;

        try {
            if (icn == 'x')
                ii = ImageIO.read(fx); // Read X.png
            else
                ii = ImageIO.read(fo); // Read O.png

            m_image = new ImageIcon(ii);
            setIcon(m_image); // Place X or O in button
        }

        catch (IOException ioe) {
            System.out.println("Unable to read icon image.");
        }
    }

    /**
     * The getter method which returns a boolean value which determines if this
     * button
     * was clicked, and if it should therefore not be clicked again so it doesn't
     * change
     * 
     * @return - true if this button was clicked, false if it wasn't
     */
    boolean getState() {
        return m_state;
    }

    /**
     * The setter method which sets the state value of the button to the value of
     * the
     * boolean parameter
     * 
     * @param state - state of the button (true if clicked, false otherwise)
     */
    void setState(boolean state) {
        m_state = state;
    }

    /**
     * The method which sends a reset signal to the TicTacToePanel parent class if
     * TicTacButtonListener detected a winner or a tie
     */
    void sendResetSignal() {
        m_panel.resetFrame();
    }
}