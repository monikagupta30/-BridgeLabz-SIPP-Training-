// Superclass
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }
}

// Main class to test
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Oreo", 4);
        Animal cat = new Cat("Daisy", 3);
        Animal bird = new Bird("Tweety", 1);

        // Demonstrate polymorphism
        dog.makeSound();   // Buddy says: Woof Woof!
        cat.makeSound();   // Whiskers says: Meow!
        bird.makeSound();  // Tweety says: Tweet Tweet!
    }
}
