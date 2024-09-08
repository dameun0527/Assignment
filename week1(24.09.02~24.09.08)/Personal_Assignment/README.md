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

- 2️⃣ 개발편 - 단계별 필수 기능 구현을 위한 코딩
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

    -  구체적으로 어떤 기능이 필요한지 파악 후 주요 메서드로 분리

    -  데이터 흐름 설계: 데이터가 클래스 간에 어떻게 흐를지 결정.

###  2️⃣ 개발편

#### Step 1. 필수 기능 가이드
##### **Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기**

[App.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
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
<span style="color: #8a3db6;"><u>입력값(숫자) 조건</u></span>

1.  양의 정수(0 포함)를 입력받기
    - 키워드: `Scanner`, `int`,`필드`

2.  사칙연산 기호(➕,➖,✖️,➗)를 입력받기
    -   키워드: `Scanner`, `char`

3.  연산 메서드 정의
    -   키워드: `if`, `else`, `switch`, `case`, `break`, `continue`
    -   사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    -   입력 받은 연산 기호를 구분하기 위해 제어문을 사용
    -   연산 오류가 발생한 경우 해당 오류에 대한 내용을 정제하여 출력

4.  무한 루프와 종료 키워드
    -   키워드 : `while` `반복(처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)`, `종료`

5. 그 외 **_혼자 생각한 예외 처리_**
    - 나눗셈 - 0으로 나누는 경우
    - 숫자가 아닌 문자열을 입력하는 경우
    - 양의 정수 외에 다른 값을 입력하는 경우 (ex. 음의 정수)
    - 


##### **Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기**

1. Calculator 클래스 정의 조건
    -   사칙연산을 수행한 후 결과값을 반환하는 메서드 구현:
        -   매개변수:  양의 정수 2개(0 포함)와 연산 기호 → 변수별 타입(short, int, double, char ... etc)
    -   연산 결과를 저장하는 컬렉션 타입 필드 생성
2.   Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
     - 연산 수행 역할은 Calculator 클래스가 담당
     - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
         -   사칙연산 기호를 적합한 타입(문자열의 `char`)으로 선언한 변수에 저장 
       
3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)

    - 키워드: `getter`, `setter`
    - 간접 접근을 통해 필드에 접근하여 결과를 <U>가져오기</U>
    - 간접 접근을 통해 필드에 접근하여 결과를 <U>수정하기</U>
    - 위에서 구현한 메서드를 App 클래스의 main 메서드에서 활용하기

4. Calculator 클래스에서 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 메서드 구현
    -   키워드 : `remove`, `컬렉션`, `저장 순서`
    -   

#### Step 2. 도전 기능 가이드
##### **Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기**

###  3️⃣ 고찰 및 회고 편


