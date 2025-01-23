package Section11.poly.basic;

public class PolyMain {
    public static void main(String[] args) {
        System.out.println("parent -> parent");
        Parent parent = new Parent();
        parent.parentMethod();

        System.out.println("child -> child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        System.out.println("parent -> child");
        Parent poly = new Child();
        poly.parentMethod();
        // poly.childMethod(); 이건 안됨.
        // 부모타입은 자식을 참조할 수 있다.

        System.out.println("child -> parent");
        // Child poly1 = new Parent();
        // 자식타입은 부모를 참조할 수 없다.
    }
}
