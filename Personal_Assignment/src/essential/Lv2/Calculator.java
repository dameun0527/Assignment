package essential.Lv2;

import java.util.*;
public class Calculator {
    // <필드 영역>
    // 연산 결과를 저장하는 컬렉션 타입 필드 ->
    // results 변수 -> List<Integer> 타입으로 선언
    private List<Integer> results;

    // <객체 데이터: 생성자>
    public Calculator() {
        this.results = new ArrayList<>(); // 결과를 저장할 ArrayList 생성
    }
    // 사칙 연산 수행 담당 메소드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        // 연산자에 따른 사칙연산 수행
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
                result = num1 / num2;
                break;
        }

        // 결과를 리스트에 저장
        results.add(result);

        // 결과 반환
        return result;
    }

    // Getter 메소드: 저장된 연산 결과를 반환
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 결과 리스트를 복사해서 반환
    }

    // Setter 메소드: 외부에서 연산 결과 리스트를 수정
    public void setResults(List<Integer> results) {
        this.results = new ArrayList<>(results);
        // 리스트를 복사하는 이유:
        // 외부에서 리스트를 변경할 때 Calculator 내부에서도 리스트가 변경될 수 있기 때문에
        // 이를 방지하기 위함
    }

    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0); // 리스트의 첫 번째 데이터 삭제
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }
}


