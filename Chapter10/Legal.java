// 1
class Foo101 {
    static int x;

    public void go() {
        System.out.println(x);
    }
}

// 2
class Foo102 {
    // make int static for it to compile
    static int x;

    public static void go() {
        System.out.println(x);
    }
}

// 3
class Foo103 {
    // initialize x
    final int x = 1;

    public void go() {
        System.out.println(x);
    }
}

// 4
class Foo104 {
    static final int x = 12;

    public void go() {
        System.out.println(x);
    }
}

// 5
class Foo105 {
    static final int x = 12;

    public void go(final int x) {
        System.out.println(x);
    }
}

// 6
class Foo106 {
    int x = 12;

    public static void go(final int x) {
        System.out.println(x);
    }
}

public class Legal {
    public static void main(String[] args) {

    }
}
