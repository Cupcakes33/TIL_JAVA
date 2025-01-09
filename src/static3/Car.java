package static3;

public class Car {
    String name;
    static int carTotNum;

    public Car(String name) {
        this.name = name;
        carTotNum++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수 : " + carTotNum);
    }
}
