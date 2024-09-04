package Array;

public class Arr03 {
    public static void main(String[] args) {
        // 얕은 복사
        int[] a = {1, 2, 3, 4, 5};
        int [] b = a; // 얕은 복사
        b[0] = 3; // b 배열의 0번째 순번 값을 3으로 수정했습니다. (1 -> 3)

        System.out.println(a[0]);
    }
}
