package Section11.poly.Overide;

public class OverideMain {
    public static void main(String[] args) {
        // 자식이 자식참조
        Child child = new Child();
        System.out.println("child -> child");
        System.out.println("value = " + child.value);
        child.method();

        // 부모가 부모참조
        Parent parent = new Parent();
        System.out.println("parent -> parent");
        System.out.println("value = "+ parent.value);
        parent.method();

        // 부모가 자식참조
        Parent ov = new Child();
        System.out.println("parent -> parent");
        System.out.println("value = "+ov.value);
        ov.method();

    }
}
