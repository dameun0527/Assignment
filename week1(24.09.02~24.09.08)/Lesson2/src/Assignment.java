import java.util.*;
// 전체 util 불러오기
public class Assignment {
    public static void main(String[] args) {
        // 1. 입력값
        Scanner sc = new Scanner(System.in);
        // 저장할 자료구조명을 입력
        String collectionName = sc.nextLine();
        // 내가 좋아하는 요리 제목을 먼저 입력
        String title = sc.nextLine();
        // 이어서 요리 레시피 한 문장씩 입력
        switch (collectionName) {
            case "List": // 입력한 자료구조명이 List인 경우
                ArrayList<String> strList = new ArrayList<>(); // 선언 + 생성
                while(true) { // 사용자가 "끝"이라고 입력할 때까지 계속 레시피를 입력 -> 횟수가 정해지지 않았기 때문에
                    String recipe = sc.nextLine();
                    if (Objects.equals(recipe, "끝")) { // 입력을 마쳤으면 마지막에 "끝" 문자 입력
                        break; // List 레시피 입력 종료
                    }
                    strList.add(recipe); // 단계별 레시피 추가
                }
                // 2. 출력값
                // 입력이 종료되면 저장한 자료구조 이름과 요리 제목을 괄호로 감싸서 먼저 출력
                title = "[ List로 저장된 " + title + " ]"; // 제목
                System.out.println(title);
                // 입력한 모든 문장 앞에 번호를 붙여서 입력 순서에 맞게 모두 출력
                for (int i = 0; i < strList.size(); i++) { // 입력한 레시피 단계가 모두 출력될 때까지 반복
                    int number = i + 1;
                    System.out.println(number + ". " + strList.get(i));
                }
                break; // 출력 종료

            case "Set": // 입력한 자료구조명이 Set인 경우
                LinkedHashSet<String> strSet = new LinkedHashSet<>();
                // Set<String>이 아닌 LinkedSet<String> -> 순서 유지를 위함
                while(true) { // 사용자가 "끝"이라고 입력할 때까지 계속 레시피를 입력 -> 횟수가 정해지지 않았기 때문에
                    String recipe = sc.nextLine();
                    if (Objects.equals(recipe,"끝")) { // 입력을 마쳤으면 마지막에 "끝" 문자 입력
                        break; // Set 레시피 입력 종료
                    }
                    strSet.add(recipe); // 단계별 레시피 추가
                }
                // 2. 출력값
                // 입력이 종료되면 저장한 자료구조 이름과 요리 제목을 괄호로 감싸서 먼저 출력
                title = "[ Set으로 저장된 " + title + " ]"; // 제목
                System.out.println(title);
                // 입력한 모든 문장 앞에 번호를 붙여서 입력 순서에 맞게 모두 출력
                Iterator iterator = strSet.iterator();
                // Set은 순서를 유지하지 않고, 인덱스로 요소에 접근할 수 없기 때문에 get(int index) 메서드 사용 불가
                // 그래서 Iterator를 사용한 순회로 각 요소에 하나씩 접근함
                for (int i = 0; i < strSet.size(); i++) { // 입력한 레시피 단계가 모두 출력될 때까지 반복
                    int number = i + 1;
                    System.out.println(number + ". " + iterator.next());
                    // `iterator.next()`: Iterator가 collection에서 다음 요소를 반환하면서, 내부적으로 다음 요소로 이동
                    // -> 순차적으로 컬렉션 요소에 접근하도록 하기 위해서 사용
                }
                break; // 출력 종료

            case "Map": // 입력한 자료구조 명이 Map인 경우
                Map<Integer, String> strMap = new HashMap<>(); // 선언 + 생성
                int lineNumber = -1;
                // Map은 내부적으로 순서를 보장하지 않음 -> 순서 반영을 위해 사용
                //
                while(true) { // 사용자가 "끝"이라고 입력할 때까지 계속 레시피를 입력 -> 횟수가 정해지지 않았기 때문에
                    String recipe = sc.nextLine();
                    if (Objects.equals(recipe,"끝")) { // 입력을 마쳤으면 마지막에 "끝" 문자 입력
                        break; // Set 레시피 입력 종료
                    }
                    strMap.put(lineNumber++, recipe); // Map은 add가 아닌 put!! 단계별 레시피 추가
                }
                // 2. 출력값
                // 입력이 종료되면 저장한 자료구조 이름과 요리 제목을 괄호로 감싸서 먼저 출력
                title = "[ Map으로 저장된 " + title + " ]"; // 제목
                System.out.println(title);
                // 입력한 모든 문장 앞에 번호를 붙여서 입력 순서에 맞게 모두 출력
                for (int i = 0; i < strMap.size(); i++) { // 입력한 레시피 단계가 모두 출력될 때까지 반복
                    int number = i + 1;
                    System.out.println(number + ". " + strMap.get(i + 1));
                }
                break; // 출력 종료
            default:
                System.out.println("저장할 수 없는 자료구조 입니다.");
        }
    }
}

// [Map]에 대한 의문점
// 1. 왜 int lineNumber = -1 로 설정했는가?
//
//
// 2. 아래 코드에서 왜 int i = 0으로 설정했는가?
//          for (int i = 0; i < strMap.size(); i++) {
//          int number = i + 1;
//          System.out.println(number + ". " + strMap.get(i + 1));
//