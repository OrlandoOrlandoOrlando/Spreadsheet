package b;

import java.util.Scanner;

public class Console {
    private static String prompt = "Welcome to the CLI!\n";

    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        do {
            System.out.print(prompt);
        } while (parse(scan.next()));

        scan.close();
    }

    private static boolean parse(String token) {
        switch(token) {
            case "exit":
                return false;
            default:
                prompt = "";
                break;
        }

        return true;
    }

}
