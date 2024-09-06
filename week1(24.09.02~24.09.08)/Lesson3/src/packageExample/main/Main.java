package packageExample.main;

import packageExample.pk1.Car;

public class Main {
    public static void main(String[] args) {
//        // 클래스의 일부분이며, 하위 패키지를 도트(.)로 구분한다.
          // 전체 클래스를 명시 (import 사용 안할 때)
          // 동시에 가져올 수 있음
//        packageExample.pk1.Car car1 = new packageExample.pk1.Car();
//        packageExample.pk2.Car car2 = new packageExample.pk2.Car();
//
//        car1.horn();
//        car2.horn();

        // import 사용
        // 동시에 여러 클래스를 불러오는 것은 불가능
        Car car1 = new Car(); // pk1 package
        car1.horn();
        packageExample.pk2.Car car2 = new packageExample.pk2.Car(); // pk2 package

    }
}
