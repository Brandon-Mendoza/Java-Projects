import java.util.*;//using scanner for user input

// Class that will be used by main to initiate 
class TicTacToeTest {
    /////////////
    private final int BOARDSIZE = 3; // size of the board

    private enum Status {
        WIN, DRAW, CONTINUE
    }; // different game states

    private char[][] board; // board representation [][] row/col
    private boolean gameOver; // if game is completed
    private boolean firstPlayer; // if its player ones turn
    //////////////

    // Constructor constructs the game
    public TicTacToeTest() {
        board = new char[BOARDSIZE][BOARDSIZE];// creates board
        firstPlayer = true;// first player goes first
        gameOver = false;// game is not over
    } // end Constructor

    // start game
    // play game function
    public void play() {
        Scanner input = new Scanner(System.in);// creates a new Scanner instance which points to the input stream passed
                                               // as argument
        int row; // row for next move
        int column; // column for next move

        System.out.println("Player X's turn.");// prints first player name
        // while game is not over switch between players turns
        while (!gameOver) {
            char player = (firstPlayer ? 'X' : 'O');// x for player 1, O for player

            // player's turn
            // while player enters invalid move, reenter new data
            System.out.printf("Player %c: Enter row ( 0, 1 or 2 ): ", player);
            row = input.nextInt();
            System.out.printf("Player %c: Enter column ( 0, 1 or 2 ): ", player);
            column = input.nextInt();

            while (!validMove(row, column)) {
                System.out.println("invalid move");
                System.out.printf("Player %c: Enter row ( 0, 1 or 2 ): ", player);
                row = input.nextInt();
                System.out.printf("Player %c: Enter column ( 0, 1 or 2 ): ", player);
                column = input.nextInt();
            }

            board[row][column] = player;// players move on board

            firstPlayer = !firstPlayer;// player switch

            printBoard();// prints updated board
            printStatus(player);// prints who's move it is
        } // ends while loop
    } // ends play function

    // This function shows game status in status bar
    private void printStatus(int player) {
        Status status = gameStatus();
        // checks game status
        switch (status) {
            case WIN:
                System.out.printf("Player %c wins.", player);
                gameOver = true;
                break;
            case DRAW:
                System.out.println("Game is a draw.");
                gameOver = true;
                break;
            case CONTINUE:
                if (player == 'X')
                    System.out.println("Player O's turn.");
                else
                    System.out.println("Player X's turn.");
                break;
        } // end switch
    } // ends printStatus function

    // This function gets the status of the game
    private Status gameStatus() {
        int a;// loop counter & row/column

        // check for a win on diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return Status.WIN;
        else if (board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2])
            return Status.WIN;

        // check for win in rows
        for (a = 0; a < 3; a++)
            if (board[a][0] != 0 && board[a][0] == board[a][1] && board[a][0] == board[a][2])
                return Status.WIN;

        // check for win in columns
        for (a = 0; a < 3; a++)
            if (board[0][a] != 0 && board[0][a] == board[1][a] && board[0][a] == board[2][a])
                return Status.WIN;

        // check for a completed game
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == 0)
                    return Status.CONTINUE; // game is not finished

        return Status.DRAW; // game is a draw
    } // end method gameStatus

    // This function displays the board
    public void printBoard() {

        System.out.println("_____________");
        for (int row = 0; row < BOARDSIZE; row++) {
            System.out.println("|   |   |   |");
            for (int column = 0; column < BOARDSIZE; column++)
                printSymbol(column, board[row][column]);

            System.out.println("|___|___|___|");
        }
    } // end method printBoard

    // print moves
    private void printSymbol(int column, char value) {
        System.out.printf("| %c ", value);

        if (column == 2)
            System.out.println("|");
    } // end method printSymbol

    // checks if players move is valid
    private boolean validMove(int row, int column) {
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == 0;
    } // end method validMove

}// end class TicTacToe

// Runs game of Tic Tac Toe
public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeTest game = new TicTacToeTest();
        game.printBoard();
        game.play();
    }
}
