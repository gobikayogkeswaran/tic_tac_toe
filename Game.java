import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }

    public void start() {
        Player currentPlayer = player1;
        Scanner scanner = new Scanner(System.in);
        boolean isGameFinished = false;

        while (!isGameFinished) {
            System.out.println("Current board:");
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                if (isWinner(currentPlayer)) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    isGameFinished = true;
                } else if (board.isBoardFull()) {
                    System.out.println("It's a draw!");
                    isGameFinished = true;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private boolean isWinner(Player player) {
        char symbol = player.getSymbol();
        char[][] currentBoard = board.getBoard();

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((currentBoard[i][0] == symbol && currentBoard[i][1] == symbol && currentBoard[i][2] == symbol) ||
                    (currentBoard[0][i] == symbol && currentBoard[1][i] == symbol && currentBoard[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((currentBoard[0][0] == symbol && currentBoard[1][1] == symbol && currentBoard[2][2] == symbol) ||
                (currentBoard[0][2] == symbol && currentBoard[1][1] == symbol && currentBoard[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        Game game = new Game(player1, player2);
        game.start();
    }
}
