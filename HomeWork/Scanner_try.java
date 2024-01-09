package HomeWork;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Scanner_try {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                // 다시 Scanner 를 통해 입력 받도록 초기화
                scanner = new Scanner(System.in);
            }
        }
    }

    // 다른 유형의 입력에 대한 메소드도 추가 가능
    public static String getString(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                // 다시 Scanner 를 통해 입력 받도록 초기화
                scanner = new Scanner(System.in);
            }
        }
    }

    // 추가로 필요한 유형의 입력 메소드를 추가 가능
}
