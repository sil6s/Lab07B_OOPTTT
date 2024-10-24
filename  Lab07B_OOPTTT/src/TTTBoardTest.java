import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TTTBoardTest {

    private TTTBoard board;

    @BeforeEach
    void setUp() {
        board = new TTTBoard();
    }

    @Test
    void testInitialBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", board.getCell(i, j));
            }
        }
    }

    @Test
    void testIsValidMove() {
        assertTrue(board.isValidMove(0, 0));
        board.setMove("X", 0, 0);
        assertFalse(board.isValidMove(0, 0));
    }

    @Test
    void testSetMove() {
        board.setMove("X", 1, 1);
        assertEquals("X", board.getCell(1, 1));
    }

    @Test
    void testIsWinHorizontal() {
        board.setMove("X", 0, 0);
        board.setMove("X", 0, 1);
        board.setMove("X", 0, 2);
        assertTrue(board.isWin("X"));
    }

    @Test
    void testIsWinVertical() {
        board.setMove("O", 0, 1);
        board.setMove("O", 1, 1);
        board.setMove("O", 2, 1);
        assertTrue(board.isWin("O"));
    }

    @Test
    void testIsWinDiagonal() {
        board.setMove("X", 0, 0);
        board.setMove("X", 1, 1);
        board.setMove("X", 2, 2);
        assertTrue(board.isWin("X"));
    }

    @Test
    void testIsTie() {
        board.setMove("X", 0, 0);
        board.setMove("O", 0, 1);
        board.setMove("X", 0, 2);
        board.setMove("X", 1, 0);
        board.setMove("O", 1, 1);
        board.setMove("X", 1, 2);
        board.setMove("O", 2, 0);
        board.setMove("X", 2, 1);
        board.setMove("O", 2, 2);
        assertTrue(board.isTie());
    }

    @Test
    void testClearBoard() {
        board.setMove("X", 0, 0);
        board.setMove("O", 1, 1);
        board.clearBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", board.getCell(i, j));
            }
        }
    }
}