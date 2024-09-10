package assignment.step4;

// 4. 추상 클래스
public class Calculator { // (1) 클래스 선언
    // (2) 필드
    private AbstractOperation operation;
    // (3) 생성자
    public Calculator(AbstractOperation operation) {
        this.operation = operation;
    }
    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }
    
    // (4) 메소드
    public double calculate(int firstNumber, int secondNumber) {
        // - 클래스: Assignment.Calculator
        // - 리턴 타입이 double calculate 메소드를 받음
        // - 메소드: calculate - String 타입의 operator 매개변수
        // - int 타입의 firstNumber, secondNumber 매개변수를 통해 피연산자 값을 받습니다.
        double answer = 0;
        answer = operation.operate(firstNumber, secondNumber);
        return answer;
        }
    };
