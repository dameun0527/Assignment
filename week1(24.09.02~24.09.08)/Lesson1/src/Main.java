import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 1. 입력값
        // 내가 좋아하는 요리 제목
        String title = sc.nextLine();
        // 요리 별점 1 ~ 5 사이 소수점 있는 실수로
        float rate = sc.nextFloat();
        // 좋아하는 요리 레시피 한문장씩 출력
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String input3 = sc.nextLine();
        String input4 = sc.nextLine();
        String input5 = sc.nextLine();
        String input6 = sc.nextLine();
        String input7 = sc.nextLine();
        String input8 = sc.nextLine();
        String input9 = sc.nextLine();
        String input10 = sc.nextLine();

        // 2. 출력값
        // 입력 종료 시 제목 먼저 출력
        System.out.println("[" + title + "]");
        // 요리 별점을 소수점 제외한 정수로만 출력
        int intRate = (int) rate;
        System.out.println(intRate);
        // 바로 뒤에 정수 별점을 5점 만점 퍼센트로 표현했을 때 값을 실수로 출력
        double percentageRate = intRate * 100 / 5.0;
        System.out.println(percentageRate);
        // 입력한 모든 문장 앞에 번호를 붙여서 모두 출력
        System.out.println("1. " + input1);
        System.out.println("2. " + input2);
        System.out.println("3. " + input3);
        System.out.println("4. " + input4);
        System.out.println("5. " + input5);
        System.out.println("6. " + input6);
        System.out.println("7. " + input7);
        System.out.println("8. " + input8);
        System.out.println("9. " + input9);
        System.out.println("10. " + input10);

    }
}