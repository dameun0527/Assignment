package operator;

public class W08 {
    public static void main(String[] args) {
         // 연산자 우선 순위 : 산술 > 비교 > 논리 > 대입]

        int x = 2;
        int y = 9;
        int z = 10;

        boolean result = x < y && y < z; // true && true
        System.out.println(result);
        System.out.println("-----");

        result = x + 10 < y && y < z; // false && true
        System.out.println(result);
        System.out.println("-----");

        result = x + 2 * 3 > y;
        System.out.println(result);
        System.out.println("-----");

        result = (x + 2) * 3 > y; // true
        System.out.println(result);
    }

    // 연산자 우선순위
}
