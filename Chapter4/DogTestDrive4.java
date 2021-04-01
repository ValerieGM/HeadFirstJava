class Dog4 {
    int size;
    String name;

    void bark() {
        if (size > 60) {
            System.out.println("Wooof! Wooof!");
        } else if (size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}

public class DogTestDrive4 {
    public static void main(String[] args) {
        Dog4 one = new Dog4();
        one.size = 70;
        Dog4 two = new Dog4();
        two.size = 8;
        Dog4 three = new Dog4();
        
        three.size = 35;
        one.bark();
        two.bark();
        three.bark();
    }
}
