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
    - [Step 1. 필수 기능: Lv 1. ~ Lv 2.](#step-1-필수-기능-가이드)
    - [Step 2. 도전 기능: Lv 3.](#step-2-도전-기능-가이드)

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
**Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기**

<details>
<summary> 코드 전체 확인</summary>

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

**_[Check_Point]_**

1.  양의 정수(0 포함)를 입력받기

2.  사칙연산 기호(➕,➖,✖️,➗)를 입력받기:  입력값(기호) 조건
    -   Scanner 사용 - 사칙연산 기호를 전달
    -   사칙연산 기호를 적합한 타입(문자열의 `char`)으로 선언한 변수에 저장

3.  입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산 진행 후 결과값을 출력:  연산 메서드 정의
    -   키워드: `if`, `switch`
    -   사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    -   입력 받은 연산 기호를 구분하기 위해 제어문을 사용
    -   연산 오류가 발생한 경우 해당 오류에 대한 내용을 정제하여 출력

4.  반복문을 사용하되, 반복의 종료를 알려주는 "exit" 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기:  무한 루프 종료 키워드
    -   키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
    -   반복문 사용


**Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기**

1. 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스 생성:  Calculator 클래스 정의 조건
    -   사칙연산을 수행한 후 결과값을 반환하는 메서드 구현:
        -   매개변수:  양의 정수 2개(0 포함)와 연산 기호 → 변수별 타입(short, int, double, char ... etc)
    -   연산 결과를 저장하는 컬렉션 타입 필드 생성
2.   Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
     - 연산 수행 역할은 Calculator 클래스가 담당
     - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
         -   사칙연산 기호를 적합한 타입(문자열의 `char`)으로 선언한 변수에 저장 
       
3. 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기:  연산 메서드 정의

    - 키워드: `if`, `switch`
    - 사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    - 입력 받은 연산 기호를 구분하기 위해 제어문을 사용
    - 연산 오류가 발생한 경우 해당 오류에 대한 내용을 정제하여 출력

4. 반복문을 사용하되, 반복의 종료를 알려주는 "exit" 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 주장하기:  무한 루프 종료
    -   키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
    -   반복문을 사용합니다.

#### Step 2. 도전 기능 가이드

###  3️⃣ 고찰 및 회고 편


