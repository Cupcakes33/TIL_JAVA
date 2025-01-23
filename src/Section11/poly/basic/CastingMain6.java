package Section11.poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }

    private static void call(Parent parent) {
        if(parent instanceof Child child){
            System.out.println("Child instance");
            child.childMethod();
        } else {
            System.out.println("nono;;");
            parent.parentMethod();
        }
    }
}
