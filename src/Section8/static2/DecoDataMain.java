package Section8.static2;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData data1 = new DecoData();
        data1.staticCall();

        System.out.println("2. 인스턴스 호출2");
        DecoData data2 = new DecoData();

    }
}
