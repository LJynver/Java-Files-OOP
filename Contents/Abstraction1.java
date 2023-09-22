package javaprojectabstraction1;

abstract class Animal { //parent class that is abstract, 
    public abstract void animalSound();
    public void sleep() {
        System.out.println("Sleeping...Zzz!");
    }
}

class Pig extends Animal { //will now inherit attributes and methods from the Animal abstract class
    public void animalSound() {
        super.sleep(); //calling the class that Animal is extended to
        System.out.println("I am waking up! Oink! Oink!");
    }
}

public class JavaProjectAbstraction1 {

    public static void main(String[] args) {
        Pig piggie = new Pig();
        piggie.animalSound();
    }
    
}
