package Section11.poly.basic;

public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod();
        // 가능!

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
        child2.childMethod();
        // 헉! 불가능!

    }
}
