package Section12.ex1;

public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();
        Duck duck = new Duck();

        Animal[] animals = {dog, cat, caw, duck};
        for (Animal animal : animals){
            soundAnimal(animal);
        }

    }

    private static void soundAnimal(Animal animal){
        System.out.println("동물울어엉엉");
        animal.sound();
        System.out.println("동물다울었어엉엉");
    }

}

