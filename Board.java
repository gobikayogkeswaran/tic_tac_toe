public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        } else {
            return false;
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getBoard() {
        return board;
    }
}
