package Class;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        char type = '0';
        car.brakePedal();

        System.out.println("type " + type);

        System.out.println("gear = " + car.gear);

        Tire tire = new Tire();
        tire.company = "금호";
    }
}