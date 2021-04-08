abstract class Animal9 {
    private String name;

    public String getName() {
        return name;
    }

    public Animal9(String theName) {
        name = theName;
    }
}

class Hippo9 extends Animal9 {
    public Hippo9(String name){
        super(name);
    }
}

public class MakeHippo {
    public static void main(String[] args) {
        Hippo9 h = new Hippo9("Buffy");
        System.out.println(h.getName());        
    }
}
