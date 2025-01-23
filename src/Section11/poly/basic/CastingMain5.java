package Section11.poly.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }

    private static void call(Parent parent) {
        if(parent instanceof Child){
            System.out.println("Child instance");
            Child child = (Child) parent;
            child.childMethod();
        } else {
            System.out.println("nono;;");
            parent.parentMethod();
        }
    }
}
