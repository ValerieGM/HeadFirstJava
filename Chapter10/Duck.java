public class Duck {
    //Static methods can't use non-static (instance) variables
    private static int size;
    public static void main(String[] args) {
        System.out.println("Size of duck is " + getSize());
    }

    public void setSize(int s) {
        size = s;
    }

    // Static methods can't use non-static methods either
    public static int getSize() {
        return size;
    }
}
