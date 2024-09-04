package Operator;

public class W06 {

    public static void main(String[] args) {
        // 대입연산자에서 주의해야 할 점!!
        // ++, -- 의 위치가 변수의 앞인지, 뒤인지
        int a = 10;
        int b = 10;
        int val = ++a + b--; // 11 + 9 = 20?
        System.out.println(a);
        System.out.println(b);
        System.out.println(val); // 21
    }
}
