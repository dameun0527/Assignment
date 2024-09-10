# [Spring 3기] Ch 2. 계산기 만들기

![enter image description here](https://cdn.pixabay.com/photo/2018/06/05/23/44/pay-3456736_1280.jpg)

# 📁 과제 소개

Java 문법 종합반 강의를 수강하고, 배운 내용을 기반으로 하여 **계산기**를 만들어보았다. 이를 통해 **Java 문법과 객체 지향 프로그래밍의 개념**을 좀 더 확실하게 익힐 수 있는 경험을 갖는 시간이었다.

## 🌏 개발 환경

- Java (JDK) 17.0.12
- IDE: IntelliJ IDEA Ultimate


## ⏲ 개발 기간

2024.09.02 ~ 2024.09.10.

## 📋 목차

- [1️⃣ 기획편 - 요구 사항 정의 및 설계](#1-기획편)

- 2️⃣ 설계 및 개발편 - 단계별 필수 기능 구현을 위한 코딩
    - [Step 1. 필수 기능: Lv 1.](#lv-1-클래스-없이-기본적인-연산을-수행할-수-있는-계산기-만들기)
    - [Step 1. 필수 기능: Lv 2.](#lv-2-클래스를-적용해-기본적인-연산을-수행할-수-있는-계산기-만들기)
    - [Step 2. 도전 기능: Lv 3.](#lv-3-enum-제네릭-람다--스트림을-이해한-계산기-만들기)

- 3️⃣ [고찰 및 회고 편 - 힘들거나 어려웠던 부분 및 소감](#3-고찰-및-회고-편)

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

**_[과제에서 명시한 Check_Point + @: 내 생각대로 정리]_**


1.  **<span style="color: #8a3db6;">입력값(숫자) 조건</span>**: 양의 정수(0 포함)를 입력받기
    - 키워드: `Scanner`, `int`,`필드`

2.  **<span style="color: #8a3db6;">입력값(연산기호) 조건</span>**: 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
    -   키워드: `Scanner`, `char`

3.  **<span style="color: #8a3db6;">연산 메소드 구현 조건</span>**
    -   키워드: `if`, `else`, `switch`, `case`, `break`, `continue`
    -   사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    -   입력 받은 연산 기호를 구분하기 위해 제어문을 사용
    -   연산 오류가 발생한 경우 해당 오류에 대한 내용을 정제하여 출력

4.  **<span style="color: #8a3db6;">main 메소드의 무한 반복 루트 구현 조건</span>**
    -   키워드 : `while`, `종료`

5. 그 외 **_혼자 생각한 예외 처리_**
    - 나눗셈 - 0으로 나누는 경우
    - 숫자가 아닌 문자열을 입력하는 경우
    - 양의 정수 외에 다른 값을 입력하는 경우 (ex. 음의 정수)
    - 


##### **Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기**

[Calculator.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
import java.util.*;
// [전체적인 구조 명시]
public class Calculator {
    // [1. 필드]
    // 연산 결과를 저장하는 컬렉션 타입 필드 ->
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

    // Setter 메소드: 외부에서 연산 결과 리스트를 설정
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
            } catch (NumberFormatException e) { // 예외처리
                System.out.println("유효한 값이 아닙니다.");
            } catch (ArithmeticException e) {
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
        // Calculator 클래스에서 구현한 메소드 호출
        calc.removeResults();
        System.out.println("삭제 후 저장된 결과: " + calc.getResults());

        // 스캐너 종료
        sc.close();
    }
}

```

</details>

**_[과제에서 명시한 Check_Point + @: 내 생각대로 정리]_**

✔ Calculator 클래스 설계하기

1. 전체적인 뼈대 구조 짜기

2. 세부적인 조건 추가
   - 항목별 키워드
     - 필드: `컬렉션`, `List`, `private`, `Integer`
     - 생성자: `public`, `this`, `ArrayList -> 이후 필요한 모든 인터페이스 메소드 고려`
     - 메소드: `int`, `매개변수`, `switch`,`return`,`예외처리`
     - 추가 요구 사항: `getter`, `setter`


✔ App 클래스 설계하기

1. 전체적인 뼈대 구조 짜기
   

#### Step 2. 도전 기능 가이드
##### **Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기**

###  3️⃣ 고찰 및 회고 편


