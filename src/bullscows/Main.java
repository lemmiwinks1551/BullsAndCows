package bullscows;
import java.util.Scanner;


public class Main {

    public static final String outputErrorLength = "Error: can't generate a secret number with a length of %d because there aren't enough unique digits.";
    public static final String  outputRndNum = "The random secret number is %s.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        StringBuilder sb = new StringBuilder(generatePseudoRandomNumber(length));

        System.out.printf(outputRndNum, sb);
        /*
        Random random = new Random();
        String[] randomNum = String.valueOf("9305").split(""); // random.nextInt(10_000)
        String[] guessNum = scanner.nextLine().split("");

        int bulls = 0, cows = 0;

        for (int i = 0; i < guessNum.length; i++) {
            if (guessNum[i].equals(randomNum[i])) {
                bulls++;
            }
        }

        for (int i = 0; i < guessNum.length; i++) {
            for (int j = 0; j < randomNum.length; j++) {
                if (guessNum[i].equals(randomNum[j]) && i != j) {
                    cows++;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String value : randomNum) {
            builder.append(value);
        }
        String randomNumOutput = builder.toString();

        if (cows == 0 && bulls == 0) {
            System.out.printf("Grade: None. The secret code is %s.", randomNumOutput);
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, randomNumOutput);
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, randomNumOutput);
        } else if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, randomNumOutput);
        }*/
    }

    private static StringBuilder generatePseudoRandomNumber (int length) {
        StringBuilder sb = new StringBuilder();

        if (length > 10) {
            System.out.printf(outputErrorLength, length);
            return sb;
        }

        while (length > 0) {
            long pseudoRandomNumber = System.nanoTime();
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
