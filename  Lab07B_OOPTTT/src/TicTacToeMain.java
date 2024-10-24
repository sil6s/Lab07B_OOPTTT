import javax.swing.SwingUtilities;

public class TicTacToeMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}