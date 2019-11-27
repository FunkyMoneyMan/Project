import java.util.Random;
import java.util.Scanner;

public class DriverLicense {
    public static void run() {
        Boolean running = true;
        Random r = new Random();
        Scanner sb = new Scanner(System.in);
        char answer[] = new char[10];
        char input[] = new char[10];
        int wrong = 0;
        String awrong = "";
        for (int x = 0; x < 10; x++) {
            input[x] = (char) (r.nextInt(4) + 97);
        }
        while (running) {
            System.out.println("Please read each question carfully\nin the given booklet and enter your answer.");
            for (int x = 1; x <= 10; x++) {
                System.out.print("Answer " + x + ": ");
                if (!callMeAnswering(sb, x).equals(Character.toString(input[x-1]))) {
                    awrong = awrong + " " + x;
                    wrong++;
                }
            }
            System.out.println("Questions you answered wrong: " + awrong);
            if (wrong >= 3)
                System.out.println("Sorry you have to take the test again\nYou had more than three questions wrong");
            if (callMe(sb)) {
                wrong = 0;
                awrong = "";
                sb.nextLine();
            } else {
                running = false;
            }
        }
    }
    public static boolean callMe(Scanner sb) {
        System.out.println("Is there a new person?");
        String input = sb.next().toLowerCase();
        if (!input.equals("y") && !input.equals("n")) {
            callMe(sb);
        } else {
            if (input.equals("y"))
                return true;
            else
                return false;
        }
        return false;
    }
    public static String callMeAnswering(Scanner sb, int x) {
        String input = sb.next().toLowerCase();
        if (!input.equals("a") && !input.equals("b") && !input.equals("c")&& !input.equals("d")) {
            System.out.println("Invalid answer");
            System.out.print("Answer " + x + ":");
            callMeAnswering(sb, x);
        } else
            return input;
        return input;
    }
}