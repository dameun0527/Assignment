package operator;

public class W10 {
    public static void main(String[] args) {
        System.out.println(3 << 2); // 12
        // 3을 오른쪽으로 2만큼 비트 연산
        // 3 = 11(2) -> 1100(2) = 12 : 두 자리 이동한 값 (8+4)
        System.out.println(3 << 1); // 6
        // 3을 오른쪽으로 1만큼 비트 연산
        // 3 = 11(2) -> 110(2) = 6 : 한 자리 이동한 값 (4+2)
    }
}
