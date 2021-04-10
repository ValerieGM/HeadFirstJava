class Boo {
    public Boo(int i) {
    }

    public Boo(String s) {
    }

    public Boo(String s, int i) {
    }
}

public class SonOfBoo extends Boo {
    public SonOfBoo() {
        super("boo");
    }

    public SonOfBoo(int i) {
        super("Fred");
    }

    public SonOfBoo(String s) {
        super(42);
    }

    /*
     * error - no suitable constructor found (symbol: constructor Boo())
     * 
     * public SonOfBoo(int i, String s) { }
     */

    /*
     * error - incompatible types (symbol: constructor Boo(java.lang.String,java.lang.String))
     * 
     * public SonOfBoo(String a, String b, String c) { super(a, b); }
     */

    public SonOfBoo(int i, int j) {
        super("man", j);
    }

    /*
     * error - incompatible types (symbol:symbol : constructor Boo(int,java.lang.String)) 
     * 
     * public SonOfBoo(int i, int x, int y) { super(i, "star"); }
     */

    public static void main(String[] args) {
    }
}
