import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Carries out a board game called Battleship that features two players
 * compete with each other.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class Battleship {

    /**
     * Constructs the game board for the player.
     *
     * @param n the size of the board
     * @return the board
     */

    public static char[][] initBoard(int n) {
        // YOUR CODE BELOW: initializes a board of size n * n
        char[][] board = new char[n][n];
        return board;
    }


    /**
     * Print out the visual presentation of the board.
     *
     * @param playerTurn the turn that alters between player 1 and 2
     * @param board the 2D array that holds the (numeric) value of the board
     * @param hitsLeft the number of hits before one player wins
     */

    public static void printBoard(int playerTurn, char[][] board,
        int hitsLeft) {
        // YOUR CODE BELOW: prints the board and player information
        //  (as in the example output)
        System.out.println("Player " + playerTurn + " ("
            + hitsLeft + " hits left):");
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == 0) {
                    System.out.print("~ ");
                }
                if (board[x][y] == 1) {
                    System.out.print("X ");
                }
                if (board[x][y] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Fire the missile and launch the alternation for value for the round of
     * the game.
     *
     * @param board the 2D array that holds the (numeric) value of the board
     * @param target the desired missile location for the round
     * @param shipLocations the list of locations read from the file
     * @param hitsLeft the counter for the players left chances
     * @return how many hitsleft for the player
     */

    public static int fireMissile(char[][] board, String target,
        String[] shipLocations, int hitsLeft) {
        // YOUR CODE BELOW: updates the board given the missile
        //  target and returns if a ship is hit

        int a = convertLocation(target)[0];
        int b = convertLocation(target)[1];
        if (isShip(target, shipLocations)) {

            if (board[a][b] == 1) {
                System.out.println("target " + target
                    + " has already been chosen!");
            } else {
                board[a][b] = 1;
                hitsLeft -= 1;
                System.out.println("Hit!");
            }
        } else {
            board[a][b] = 2;
            System.out.println("Miss!");
        }

        return hitsLeft;
    }
    /**
     * Identifies if the missile target is in the list of locations.
     *
     * @param target the desired missile location for the round
     * @param shipLocations the list of locations read from the file
     * @return boolean indicating if the target is ine the list of locations
     */

    public static boolean isShip(String target, String[] shipLocations) {
        // YOUR CODE BELOW: returns if location is ship
        for (String vs : shipLocations) {
            if (target.equals(vs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Coordinate the different expression of the location/coordination on the
     * board.
     *
     * @param coordinate the user input of coordinate that contains a letter and
     * a number
     * @return the converted index of the location on the board
     *
     */

    public static int[] convertLocation(String coordinate) {
        // YOUR CODE BELOW: returns the integer indices corresponding
        //  with the coordinate string
        int[] converted = new int[2];
        coordinate = coordinate.toLowerCase();
        char x = coordinate.charAt(0);
        char y = coordinate.charAt(1);
        converted[0] = x - 'a';
        converted[1] = Character.getNumericValue(y) - 1;
        return converted;
    }

    /**
     * Carries out the execution of the game.
     *
     * @param args contains the supplied command-line arguments as an array of
     * String objects
     * @throws FileNotFoundException when the file isn't found
     */

    public static void main(String[] args) {
        int fileInd = (args.length > 0) ? Integer.parseInt(args[0])
            : new Random().nextInt(4);

        String filename = "game" + fileInd + ".txt";

        try {

            Scanner fileReader = new Scanner(new File(filename));
            Scanner inputScanner = new Scanner(System.in);

            // YOUR CODE BELOW: carries out the execution of the game
            //  using the methods defined above
            int n = fileReader.nextInt();
            char[][] board1 = initBoard(n);
            char[][] board2 = initBoard(n);
            fileReader.nextLine();
            String deal1 = fileReader.nextLine();
            String deal2 = fileReader.nextLine();
            String[] local1 = deal1.split(" ");
            String[] local2 = deal2.split(" ");

            boolean play  = true;
            int playerTurn = 1;
            int hitsLeft1 = 7;
            int hitsLeft2 = 7;

            printBoard(playerTurn, board1, hitsLeft1);
            System.out.print("Enter missile location: ");
            Scanner enterLocal = new Scanner(System.in);
            String target1 = enterLocal.next();
            hitsLeft1 = fireMissile(board1, target1, local2, hitsLeft1);
            printBoard(playerTurn, board1, hitsLeft1);
            System.out.println("\n \n");
            System.out.println("----------");
            System.out.println("\n \n");
            playerTurn += 1;


            while (play) {

                if (playerTurn % 2 == 1) {

                    playerTurn = 1;
                    printBoard(playerTurn, board1, hitsLeft1);
                    System.out.print("Enter missile location: ");
                    Scanner enterLocal1 = new Scanner(System.in);
                    target1 = enterLocal1.next();
                    hitsLeft1 = fireMissile(board1, target1, local2, hitsLeft1);
                    printBoard(playerTurn, board1, hitsLeft1);
                    System.out.println("\n \n");
                    System.out.println("----------");
                    System.out.println("\n \n");


                    if (hitsLeft1 == 0) {
                        play = false;
                        printBoard(playerTurn, board1, hitsLeft1);
                        System.out.println("The winner"
                            + "is Player 1");
                    }

                } else {

                    playerTurn = 2;
                    printBoard(playerTurn, board2, hitsLeft2);
                    System.out.print("Enter missile location: ");
                    Scanner enterLocal2 = new Scanner(System.in);
                    String target2 = enterLocal2.next();
                    hitsLeft2 = fireMissile(board2, target2, local1, hitsLeft2);
                    printBoard(playerTurn, board2, hitsLeft2);
                    System.out.println("\n \n");
                    System.out.println("----------");
                    System.out.println("\n \n");


                    if (hitsLeft2 == 0) {
                        play = false;
                        printBoard(playerTurn, board2, hitsLeft2);
                        System.out.println("The winner" + " is Player 2");
                    }
                }
                playerTurn += 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Make sure that " + filename
                + " is in the current directory!");
        }
    }
}



