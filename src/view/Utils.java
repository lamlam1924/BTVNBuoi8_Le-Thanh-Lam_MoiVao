package View;

import java.util.Scanner;

public class Utils {

    public static String getValue(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println(input);
        return sc.nextLine();
    }

    public static int checkInt(String s) {
        int num = 0;
        while (true) {
            try {
                num = Integer.parseInt(getValue(s));
                if (num > 0) {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Input invaild number");
            }
        }
    }
}
