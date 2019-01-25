package dbTest.multi_thread_in_action;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] eachStr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = eachStr.length - 1; i >= 0; i --) {
            stringBuilder.append(eachStr[i]).append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
