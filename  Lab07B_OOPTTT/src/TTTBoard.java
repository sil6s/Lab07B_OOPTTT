public class TTTBoard {
    private static final int ROW = 3;
    private static final int COL = 3;
    private String[][] board;

    public TTTBoard() {
        board = new String[ROW][COL];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    public boolean isWin(String player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) ||
                    (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
                return true;
            }
        }
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    public boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }

    public void setMove(String player, int row, int col) {
        board[row][col] = player;
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }
}