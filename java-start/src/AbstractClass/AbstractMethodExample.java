package AbstractClass;

public class AbstractMethodExample {
    public static void main(String[] args) {
        //추상클래스로는 새로운 객체 생성할 수 없다.
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        animalSound(new Dog());
        animalSound(new Cat());


    }
    public static void animalSound(Animal animal){
        animal.sound();
    }
}
