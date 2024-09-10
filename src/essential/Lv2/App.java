package essential.Lv2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // Calculator 클래스에서 객체 호출 > 객체 초기화
        // 인스턴스화
        Calculator calc = new Calculator();
        // sc 변수 선언 + Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true) {
            try { // 예외 처리의 `try-catch`
                // 첫 번째 숫자 입력
                System.out.println("첫 번째 숫자를 입력하세요: ");
                // sc.next()로 입력된 값: 문자열 > .parseInt()를 통해 int로 변환
                int num1 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 연산 기호 입력
                System.out.println("사칙연산 기호를 입력하세요: ");
                // 입력한 문자열 호출
                char operator = sc.next().charAt(0);

                // 입력값이 사칙 연산 기호가 아닌 경우 예외 처리
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("잘못된 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                    continue;
                }

                // 두 번째 숫자 입력
                System.out.println("두 번째 숫자를 입력하세요: ");
                // sc.next()로 입력된 값: 문자열 > .parseInt()를 통해 int로 변환
                int num2 = Integer.parseInt(sc.next());

                // 0을 포함한 양의 정수인지 확인
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 참조변수 calc + 도트 연산자 > Calculator 클래스의 calculate 메소드 호출
                int result = calc.calculate(num1, num2, operator);

                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (Yes / Exit) ");
                String answer = sc.next();
                // 저장된 값이 'Exit'과 동일한 경우 종료
                if (answer.equals("Exit")) {
                    break;
                }
            } catch (NumberFormatException e) { // 예외처리 1: 입력 값이 숫자가 아닐 때
                System.out.println("유효한 값이 아닙니다.");
            } catch (ArithmeticException e) { // 예외처리 2: 나눗셈 과정에서 분모값에 0을 입력했을 때
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }

        // 추가 요구 사항
        // calc 참조변수를 통해 Calculator 클래스에서 정의한 .getResults() 메소드 호출 (getter)
        System.out.println("모든 연산 결과: " + calc.getResults());
        System.out.println("----------------");

        // 새로운 리스트 생성 > 추가된 값이 내부(results)에 영향 주지 않기 위해
        List<Integer> newResults = new ArrayList<>();
        // 새로운 값 추가
        newResults.add(10);
        // calc 객체의 setResults 호출 > newResults 저장(results 수정)
        calc.setResults(newResults);
        // 새로 수정된 newResults를 getResults 메소드로 호출
        System.out.println("수정된 연산 결과: " + calc.getResults());


        System.out.println("가장 먼저 저장된 데이터를 삭제합니다.");
        // Calculator 클래스에서 구현한 remove 메소드 호출
        calc.removeResults();
        // 삭제를 반영한 결과값 getResults로 호출
        System.out.println("삭제 후 저장된 결과: " + calc.getResults());

        sc.close();
    }
}
