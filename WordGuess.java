import java.util.Random;
import java.util.Scanner;

/**
 * Creates a word guessing games that has five chances.
 *
 * @author ehuang42
 * @version 13.31
 */

public class WordGuess {

    /**
     * Creates word guessing main class.
     */

    static final String[] CANDIDATES = {"cat", "dad", "dog", "mom", "rat"};

    /**
     * @param args the string array arguments!
     */

    public static void main(String[] args) {

    /**
     * Creates a main metheod for the word guessing game.
     *
     * @param secretWord the random word which is the right answer
     * @param left the times of guesses left
     * @param board the stringbuilder that reveals all letters that were
     * correctly guessed
     * @param missed the stringbuilder that holds all the missed letters
     * @param in the scanner that user inputs guesses
     * @param play the boolean value of continuing the game or not
     */
        String secretWord = args.length > 0
            ? CANDIDATES[Integer.parseInt(args[0])]
            : CANDIDATES[new Random().nextInt(CANDIDATES.length)];

        // Your code goes here:

        int left = 5;
        StringBuilder board = new StringBuilder("___");
        StringBuilder missed = new StringBuilder("");
        Scanner in = new Scanner(System.in);
        Boolean play = true;

        System.out.println("Missed letters (" + left + " left): "
            + missed.toString());
        System.out.println("Current guess: " + board.toString());
        System.out.print("Guess a letter: ");
        String current = in.next();
        System.out.print("\n");

        while (play && left > 0) {

            if (secretWord.indexOf(current.charAt(0)) >= 0) {

                for (int x = 0; x < secretWord.length(); x++) {
                    if (secretWord.charAt(x) == current.charAt(0)) {
                        board.setCharAt(x, current.charAt(0));
                    }
                }

                if (secretWord.compareTo(board.toString()) == 0) {

                    System.out.println("Missed letters: " + missed.toString());
                    System.out.println("Final guess: " + board.toString());
                    System.out.println("Congratulations! You got it!");
                    play = false;

                } else {

                    System.out.println("Missed letters ("
                        + left + " left): " + missed.toString());
                    System.out.println("Current guess: "
                        + board.toString());
                    System.out.print("Guess a letter: ");
                    current = in.next();
                    System.out.print("\n");
                }

            } else {

                left -= 1;
                missed.append(current.charAt(0));

                if (left == 0) {

                    play = false;
                    System.out.println("Missed letters: "
                        + missed.toString());
                    System.out.println("Final guess: " + board.toString());
                    System.out.println("Sorry, too many misses. "
                        + "The secret word was " + secretWord);
                } else {

                    System.out.println("Missed letters ("
                        + left + " left): " + missed.toString());
                    System.out.println("Current guess: "
                        + board.toString());
                    System.out.print("Guess a letter: ");
                    current = in.next();
                    System.out.print("\n");
                }
            }
        }
    }
}
