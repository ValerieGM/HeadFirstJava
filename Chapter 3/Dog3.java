public class Dog3 {
    String name;

    public static void main(String[] args) {
        Dog3 dog1 = new Dog3();
        dog1.bark();
        dog1.name = "Bart";

        Dog3[] myDogs = new Dog3[3];
        myDogs[0] = new Dog3();
        myDogs[1] = new Dog3();
        myDogs[2] = dog1;

        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        System.out.print("last dog’s name is ");
        System.out.println(myDogs[2].name);
        
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

    public void bark() {
        System.out.println(name + " says Ruff!");
    }
}
