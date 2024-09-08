package essential.Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1) 양의 정수(0 포함) 입력받기
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // 첫 번째 숫자 입력
                System.out.println("첫 번째 숫자를 입력하세요: ");
                int num1 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 연산 기호 입력
                System.out.println("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                // 사칙 연산 기호가 아닌 경우 예외 처리
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("잘못된 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                    continue;
                }

                // 두 번째 숫자 입력
                System.out.println("두 번째 숫자를 입력하세요: ");
                int num2 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 연산 수행 및 결과 출력
                int result = 0;
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        // 예외 처리
                        if (num2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                }
                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (Yes / Exit):");
                String answer = sc.next();
                if (answer.equals("Exit")) {
                    break;
                }
            }
            // 또 다른 예외 처리 방법: Try-Catch
            catch (NumberFormatException e) {
                System.out.println("유효한 값을 입력해주세요.");
            }
        }
        sc.close();
    }
}
