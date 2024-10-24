import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private TTTBoard board;
    private TTTTileButton[][] buttons;
    private String currentPlayer;
    private JLabel statusLabel;

    public Game() {
        board = new TTTBoard();
        buttons = new TTTTileButton[3][3];
        currentPlayer = "X";

        setTitle("Silas's Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TTTTileButton(row, col);
                buttons[row][col].addActionListener(this);
                gamePanel.add(buttons[row][col]);
            }
        }

        statusLabel = new JLabel("Player X's turn");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);

        add(gamePanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TTTTileButton clickedButton = (TTTTileButton) e.getSource();
        int row = clickedButton.getRow();
        int col = clickedButton.getCol();

        if (board.isValidMove(row, col)) {
            board.setMove(currentPlayer, row, col);
            clickedButton.setText(currentPlayer);
            clickedButton.setEnabled(false);

            if (board.isWin(currentPlayer)) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            } else if (board.isTie()) {
                JOptionPane.showMessageDialog(this, "It's a tie!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                statusLabel.setText("Player " + currentPlayer + "'s turn");
            }
        }
    }

    private void resetGame() {
        board.clearBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
            }
        }
        currentPlayer = "X";
        statusLabel.setText("Player X's turn");
    }
}