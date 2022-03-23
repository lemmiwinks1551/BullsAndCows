package bullscows;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static final String outputErrorLength = "Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n";
    public static final String outputRndNum = "The random secret number is %s.";
    public static final String outputGameStart1 = "Please, enter the secret code's length:";
    public static final String outputGameStart2 = "Okay, let's start a game!";
    public static final String outputGameEnd = "Congratulations! You guessed the secret code.";
    public static final String outputTurn = "Turn %d:\n";

    public static final String outputNoBullsNoCows = "Cannot find number of bulls or number of cows or None after the input.\n";
    public static final String noBulls = "Grade: %d cows\n";
    public static final String noCows = "Grade: %d bulls\n";
    public static final String haveBullsAndCows = "Grade: %d bull and %d cow\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] guessNum;

        System.out.println(outputGameStart1);
        int length = scanner.nextInt();

        StringBuilder randomNum = new StringBuilder(generatePseudoRandomNumber(length));

        System.out.println(outputGameStart2);
        int bulls = 0, cows = 0, turn = 1;

        guessNum = scanner.nextLine().split("");

        while (true) {
            System.out.printf(outputTurn, turn);
            guessNum = scanner.nextLine().split("");
            bulls = bullsCount(guessNum, randomNum);
            cows = cowsCount(guessNum, randomNum);

            if (cows == 0 && bulls == 0) {
                System.out.print(outputNoBullsNoCows);
            } else if (bulls == 0) {
                System.out.printf(noBulls, cows);
            } else if (cows == 0 && bulls != length) {
                System.out.printf(noCows, bulls);
            } else if (bulls > 0 && cows > 0) {
                System.out.printf(haveBullsAndCows, bulls, cows);
            } else if (bulls == length) {
                System.out.printf(noCows, bulls);
                System.out.print(outputGameEnd);
                break;
            }
            turn++;
        }

    }

    private static int bullsCount (String[] guessNum, StringBuilder randomNum) {
        int bulls = 0;
        for (int i = 0; i < guessNum.length; i++) {
            if (guessNum[i].equals(randomNum.toString().split("")[i])) {
                bulls++;
            }
        }
        return bulls;
    }

    private static int cowsCount (String[] guessNum, StringBuilder randomNum) {
        int cows = 0;
        for (int i = 0; i < guessNum.length; i++) {
            for (int j = 0; j < randomNum.length(); j++) {
                if (guessNum[i].equals(randomNum.toString().split("")[j]) && i != j) {
                    cows++;
                }
            }
        }
        return cows;
    }

    private static StringBuilder generatePseudoRandomNumber (int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        if (length > 10) {
            System.out.printf(outputErrorLength, length);
            return sb;
        }

        while (length > 0) {
            long pseudoRandomNumber = Math.abs(random.nextLong());
            for (char ch : String.valueOf(pseudoRandomNumber).toCharArray()) {
                if (!sb.toString().contains(String.valueOf(ch)) && length > 0) {
                    sb.append(ch);
                    length--;
                }
            }
        }
        return sb;
    }
}






















