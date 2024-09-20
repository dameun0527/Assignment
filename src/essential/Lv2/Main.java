package essential.Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("첫 번째 숫자를 입력하세요.");
                int num1 = Integer.parseInt(sc.next());

                System.out.println("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                System.out.println("두 번째 숫자를 입력하세요: ");
                int num2 = Integer.parseInt(sc.next());

                int result = calc.calculate(num1, num2, operator);

                System.out.println("결과: " + result);

                System.out.println("더 계산하시겠습니까? (Yes / Exit) ");
                String answer = sc.next();
                if (answer.equals("Exit")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
