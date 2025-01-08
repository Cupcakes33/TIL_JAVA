package Section8.static2;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall(){
        // instanceValue++;  static 메서드는 인스턴스 변수에 접근할 수 없다!
        // instanceMethod(); // static 메서드는 인스턴스 메서드에 접근할 수 없다!
        //java: non-static method instanceMethod() cannot be referenced from a static context
        staticValue++; // 정적 변수에 접근 가능
        staticMethod(); // 정적 메서드에 접근 가능
    }

    public static void staticCall2(DecoData data) {
        data.instanceValue++;
        data.instanceMethod();
    }
    public void instanceCall(){
        instanceValue++; // 인스턴스 변수 접근 가능
        instanceMethod(); // 인스턴스 메서드 접근 가능

        staticValue++; // 정적 변수에 접근 가능
        staticMethod(); // 정적 메서드에 접근 가능
    }

    private void instanceMethod() {
        System.out.println("instanceValue=" + instanceValue); // 인스턴스 변수에 접근 가능
        System.out.println("staticValue=" + staticValue); // 정적 변수에 접근 가능
    }

    private static void staticMethod() {
        System.out.println("staticValue=" + staticValue);
    }
}
