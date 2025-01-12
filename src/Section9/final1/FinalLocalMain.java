package Section9.final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능

        final int data2 = 10;
    }

    static void method(final int parameter) {
    // parameter = 20; 할당받은 파라미터의 값을 변경할 수 없음.
    }
}
