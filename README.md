# [Spring 3기] Ch 2. 계산기 만들기

![enter image description here](poster.jpg)

# 📁 과제 소개

Java 문법 종합반 강의를 수강하고, 배운 내용을 기반으로 하여 **계산기**를 만들어보았다. 이를 통해 **Java 문법과 객체 지향 프로그래밍의 개념**을 좀 더 확실하게 익힐 수 있는 경험을 갖는 시간이었다.

## 🌏 개발 환경

- Java (JDK) 17.0.12
- IDE: IntelliJ IDEA Ultimate


## ⏲ 개발 기간
#### < Task Progress >

|        Date         | Progress                                                                                |
|:-------------------:|-----------------------------------------------------------------------------------------|
| 24.09.02 ~ 24.09.06 | Java 문법 종합반 강의 3주차까지 수강 후 각 주차별 과제 제출<br>개인 과제 요구 사항 이해 및 기반 설계<br>배운 내용 및 이해 안되는 부분 복습 |
| 24.09.07 ~ 24.09.09 | 필수 구현 과제 마무리, README 작성 시작                                                      |
| 24.09.09 ~ 24.09.10 | 과제 코드 일부(주석 포함) 수정, README 수정, 트러블슈팅 작성                                    |
| 24.09.11 ~ | 과제 제출!!!!!!!!!!!!!! |

## 📋 목차

1️⃣ 기획편 - 요구 사항 정의 및 설계

2️⃣ 설계 및 개발편 - 단계별 필수 기능 구현을 위한 코딩
- [Step 1. 필수 기능: Lv 1.](#lv-1-클래스-없이-기본적인-연산을-수행할-수-있는-계산기-만들기)
- [Step 1. 필수 기능: Lv 2.](#lv-2-클래스를-적용해-기본적인-연산을-수행할-수-있는-계산기-만들기)
- [Step 2. 도전 기능: Lv 3.](#lv-3-enum-제네릭-람다--스트림을-이해한-계산기-만들기) - 미완성

3️⃣ [고찰 및 회고 편 - 힘들거나 어려웠던 부분 및 소감](#3-고찰-및-회고-편)

<br>

### 1️⃣ 기획편

1. 요구 사항 숙지
    - 각 단계 별 필요로 하는 기능이 무엇인지

    - [공통] 사용자 인터페이스 방식 결정

    - 예외 항목 및 처리 방식 결정
2. 설계
    -  계산기 기능 구현에 필요한 클래스 설계

    -  구체적으로 어떤 기능이 필요한지 파악 후 주요 메소드로 분리

    -  데이터 흐름 설계: 데이터가 클래스 간에 어떻게 흐를지 결정.

###  2️⃣ 설계 및 개발편

#### Step 1. 필수 기능 가이드
##### **Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기**

[App.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1) 양의 정수(0 포함) 입력받기
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // 첫 번째 숫자 입력
                System.out.println("첫 번째 숫자를 입력하세요: ");
                int num1 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }
                // 연산 기호 입력
                System.out.println("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);
                // 두 번째 숫자 입력
                System.out.println("두 번째 숫자를 입력하세요: ");
                int num2 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }
                // 연산 수행 및 결과 출력
                int result = 0;
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
                        // 예외 처리
                        if (num2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                }
                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (Yes / Exit):");
                String answer = sc.next();
                if (answer.equals("Exit")) {
                    break;
                }
            }
            // 또 다른 예외 처리 방법: Try-Catch
            catch (NumberFormatException e) {
                System.out.println("유효한 값을 입력해주세요.");
            }
        }
        sc.close();
    }
}
```

</details>

✔ App 클래스 설계하기

1. 전체적인 구조: 필요한 기능이 무엇인지 파악하기
   - 한 클래스 내에서 연산 / 입출력 모두 처리 
   - 입력값 관련 조건 부여(변수 저장 방식 등)
   - 연산자 종류별 연산 수행 메소드 
   - 연산 종료는 특정 키워드 입력 시에만 
   - 연산 오류 발생 시 에러 처리 방식
2. 주요 로직 구현하기 (콘솔 기반)
3. 세부적인 설계하기
   - 항목별 주요 키워드
       - 클래스: `public`
       - 메소드: `public`, `static`, `void`
       - 입력 처리: `Scanner`, `int`, `Integer`, `next()`, `char`, `parseInt()`, `charAt()` 
       - 제어문: `while`, `switch`, `break`
       - 예외 처리: `if`, `continue`, `try-catch`


##### **Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기**

[Calculator.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
import java.util.*;
// [전체적인 구조 명시]
public class Calculator {
    // [1. 필드]
    // 연산 결과를 저장하는 컬렉션 타입 필드
    // results 변수 -> List<Integer> 타입으로 선언
    private List<Integer> results;

    // [2. 객체 데이터: 생성자]
    public Calculator() {
        this.results = new ArrayList<>(); // 결과를 저장할 ArrayList 생성
    }
    // [3. 연산 수행 담당 메소드]
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
    
    // 추가 요구 사항

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

```


</details>

✔ Calculator 클래스 설계하기

1. 전체적인 구조 짜기: 주석으로 표시
   - 연산 수행 메소드 (사칙연산)
   - 연산 결과를 저장하는 컬렉션 타입 필드
   - 연산 결과 저장 필드 캡슐화
   - 외부에서 캡슐화 된 필드로 간접 접근 후 결과값 가져오기 / 수정하기 / 제거하기
2. 주요 로직 구현하기 (콘솔 기반)
3. 세부적인 설계하기
    - 항목별 주요 키워드
        - 필드: `컬렉션`, `List`, `private`, `Integer`
        - 생성자: `public`, `this`, `ArrayList -> 이후 필요한 모든 인터페이스 메소드 고려`
        - 메소드: `int`, `char`, `switch`,`return`
        - 추가 요구 사항: `getter`, `setter`, `isEmpty`, `remove`


[App.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Calculator class에서 객체 호출 > 객체 초기화
        // 인스턴스화
        Calculator calc = new Calculator();
        // sc 변수 선언 + Scanner 객체 생성 
        Scanner sc = new Scanner(System.in);
        
        // 반복문 시작
        while (true) {
            // 예외 처리의 `try-catch`
            try { 
                // 첫 번째 숫자 입력
                System.out.println("첫 번째 숫자를 입력하세요: ");
                // sc.next()로 입력된 값: 문자열 > .parseInt()를 통해 int로 변환
                int num1 = Integer.parseInt(sc.next());
                // 0을 포함한 양의 정수인지 확인
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 연산 기호 입력
                System.out.println("사칙연산 기호를 입력하세요: ");
                // 입력한 문자열 호출
                char operator = sc.next().charAt(0);

                // 입력값이 사칙 연산 기호가 아닌 경우 예외 처리
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("잘못된 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                    continue;
                }

                // 두 번째 숫자 입력
                System.out.println("두 번째 숫자를 입력하세요: ");
                // sc.next()로 입력된 값: 문자열 > .parseInt()를 통해 int로 변환
                int num2 = Integer.parseInt(sc.next());

                // 0을 포함한 양의 정수인지 확인
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                // 참조변수 calc + 도트 연산자 > Calculator 클래스의 calculate 메소드 호출
                int result = calc.calculate(num1,num2,operator);

                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (Yes / Exit) ");
                String answer = sc.next();
                // 저장된 값이 'Exit'과 동일한 경우 종료
                if (answer.equals("Exit")) {
                    break;
                }
            } catch (NumberFormatException e) { // 예외처리 1: 입력 값이 숫자가 아닐 때
                System.out.println("유효한 값이 아닙니다.");
            } catch (ArithmeticException e) { // 예외처리 2: 나눗셈 과정에서 분모값에 0을 입력했을 때
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }
        
        // 추가 요구 사항
        // calc 참조변수를 통해 Calculator 클래스에서 정의한 .getResults() 메소드 호출 (getter)
        System.out.println("모든 연산 결과: " + calc.getResults());
        System.out.println("----------------");

        
        // 새로운 리스트 생성 > 추가된 값이 내부(results)에 영향 주지 않기 위해
        List<Integer> newResults = new ArrayList<>();
        // 새로운 값 추가
        newResults.add(10);
        // calc 객체의 setResults 호출 > newResults 저장(results 수정)
        calc.setResults(newResults);
        // 새로 수정된 newResults를 getResults 메소드로 호출
        System.out.println("수정된 연산 결과: " + calc.getResults());
        
        
        System.out.println("가장 먼저 저장된 데이터를 삭제합니다.");
        // Calculator 클래스에서 구현한 remove 메소드 호출
        calc.removeResults();
        // 삭제를 반영한 결과값 getResults로 호출
        System.out.println("삭제 후 저장된 결과: " + calc.getResults());

        // 스캐너 종료
        sc.close();
    }
}

```

</details>

✔ App 클래스 설계하기

1. 전체적인 구조 짜기: 주석으로 표시
    - 주요 연산 메소드를 호출하기 위한 객체 생성 / 인스턴스화
    - 입력값 구분 및 예외 처리를 위한 제어문
    - 저장된 연산 결과를 가져오고, 수정하고, 제거하는 메소드를 호출하여 결과값 출력
2. 주요 로직 구현하기 (콘솔 기반)
3. 세부적인 설계하기
   - 항목별 주요 키워드
        - 클래스 및 객체 초기화
        - 입력 처리: `Scanner`, `int`, `Integer`, `next()`, `char`, `parseInt()`, `charAt()`
        - 제어문: `while`, `if`, `.equals()`, `break`, `continue`
        - 예외 처리: `try-catch`, `NumberFormatException`, `ArithmeticException`
        - 추가 요구 사항: `getter: .getResults`, `setter: setResults`, `remove: removeResults`
   

#### Step 2. 도전 기능 가이드
##### **Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기**

후에 시간이 된다면 좀 더 공부해서 도전해보기로 함.

###  3️⃣ 고찰 및 회고편
#### 회고

[[자세한 내용: 블로그 링크]](https://jisuryu0527.tistory.com/21)

- 코드에 대해 모르는 것이 너무 많아서 매번 찾는 데에 시간을 너무 많이 뺏겼다.


- 예외 처리 과정에서, `throw`가 매우 간결하고 좋은 메소드라는 것을 새로 알게 됐지만, 공부용으로 `if`도 넣어보고, 처음으로 `try-catch` 구문
도 써봤다. 



#### 개선하고 싶은 점이 있다면?

1. 데스크탑이나 휴대폰 어플리케이션에 있는 계산기의 연속적인 연산 기능
2. 좀 더 다양한 연산자와 부호, 입력값에 따른 다양한 연산 메소드 구현
2. 연산 결과 값을 저장하고, 저장된 결과 값으로 되돌아가는 기능 (예를 들면 문서나 포토샵 작업 같은 프로그램에서 Ctrl + Z 기능이나 작업 내역 기능; 횟수 제한 있음)
3. GUI와 연결
