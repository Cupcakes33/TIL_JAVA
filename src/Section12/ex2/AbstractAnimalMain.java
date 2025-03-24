package Section12.ex2;

import Section12.ex1.Animal;

public class AbstractAnimalMain {
    public static void main(String[] args) {
        // 추상클래스는 new 키워드로 생성할 수 없다.
        // AbstractAnimal animal = new AbstractAnimal();
        // 'AbstractAnimal'은(는) abstract이며, 인스턴스화할 수 없습니다

        Dog dog = new Dog();
        Cat cat = new Cat();

        soundAnimal(cat);
        soundAnimal(dog);

        AbstractAnimal[] animals = {dog, cat};
        for (AbstractAnimal animal : animals){
            soundAnimal(animal);
            animal.move();
        }


    }

    public static void soundAnimal(AbstractAnimal animal){
        animal.sound();
    }
}
