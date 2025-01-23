package Section11.poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        // 다형적 참조
        Parent poly = new Child();

        // 다운캐스팅(부모 타입 -> 자식 타입)
        ((Child) poly).childMethod();
    }
}
