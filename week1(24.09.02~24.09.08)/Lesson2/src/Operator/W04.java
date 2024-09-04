package Operator;

public class W04 {
    // 논리 연산자
    // 비교 연산의 결과값으로 받을 수 있는 boolean 값을 연결하는 연산자
    // 조건을 연결하였을 때 boolean 값들을 조합하여 참(true) 또는 거짓(false) 값인 boolean 값을 출력
    // &&(AND). ||(OR), !(Not)
    public static void main(String[] args) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = false;

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        // (1) 피연산자 중 하나라도 true이면 true => 또는(OR : ||)
        System.out.println("------------");
        System.out.println(flag1 || flag2); // true
        System.out.println(flag1 || flag2 || flag3); // true

        // (2) 피연산자가 모두 true이면 true => 그리고(AND : &&)
        System.out.println("------------");
        System.out.println(flag1 && flag2); // true
        System.out.println(flag1 && flag2 && flag3); // false

        // (3) AND
        System.out.println("------------");
        System.out.println((5 > 3) && (3 > 1)); // true && true -> true
        System.out.println((5 > 3) && (3 < 1)); // true && false -> false

        // (4) OR
        System.out.println("------------");
        System.out.println((5 > 3) || (3 > 1)); // true || true -> true
        System.out.println((5 > 3) || (3 < 1)); // true || false -> true
        System.out.println((5 < 3) || (3 < 1)); // false || false -> false

        // System.out.println(1 < 3 < 5); // 불가능!

        // 논리 부정 연산자( ! : Not)
        System.out.println("------------");
        System.out.println(!flag1); // Not true -> false
        System.out.println(!flag3); // Not false -> true
        System.out.println(!(5 == 5)); // Not true -> false
        System.out.println(!(5 == 3)); // Not false -> true

    }
}
