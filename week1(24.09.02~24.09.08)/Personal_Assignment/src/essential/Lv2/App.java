package essential.Lv2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // 1) Calculator 클래스의 인스턴스 생성
        Calculator calc = new Calculator();

        Scanner sc = new Scanner(System.in);
        // 반복문 시작
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

                // Calculator 클래스의 calculate 메서드를 통해 연산 수행
                int result = calc.calculate(num1,num2,operator);

                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (Yes / Exit) ");
                String answer = sc.next();
                if (answer.equals("Exit")) {
                    break;
                    }
                }
            catch (Exception e) {
                System.out.println("유효한 값이 아닙니다.");
            }
        }
        // 저장된 모든 연산 결과 출력
        System.out.println("모든 연산 결과: " + calc.getResults());
        System.out.println("----------------");

        // Setter 메서드: 연산 결과 수정해보기
        List<Integer> newResults = new ArrayList<>();
        newResults.add(10);
        calc.setResults(newResults);
        System.out.println("수정된 연산 결과: " + calc.getResults());

        // 가장 먼저 저장된 데이터 삭제
        System.out.println("가장 먼저 저장된 데이터를 삭제합니다.");
        calc.removeResults();
        System.out.println("삭제 후 저장된 결과: " + calc.getResults());

        sc.close();
    }
}
