package assignment.step4;


public class Main {
    public  void main () {
        Calculator calculator = new Calculator(new AddOperation());
        System.out.println(calculator.calculate(10,20));
        calculator.setOperation(new MultiplyOperation());
        System.out.println(calculator.calculate(10,20));

    }
}