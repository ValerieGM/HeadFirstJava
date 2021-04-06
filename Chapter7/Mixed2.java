/* 
*Superclass
*/
class A {
    int ivar = 7;

    void m1() {
        System.out.print("A's m1, ");
    }

    void m2() {
        System.out.print("A's m2, ");
    }

    void m3() {
        System.out.print("A's m3, ");
    }
}

/*
 * Subclass
 */
class B extends A {
    void m1() {

        /*
         * Override
         */
        System.out.print("B's m1, ");
    }
}

/*
 * Subclass
 */
class C extends B {

    /*
     * Override
     */
    void m3() {
        System.out.print("C's m3, " + (ivar + 6));
    }
}

public class Mixed2 {
    public static void main(String[] args) {
        // A a = new A();
        // B b = new B();
        // C c = new C();

        /*
         * Polymorphism
         */
        A a2 = new C();

        // Code Candidates
        a2.m1();
        a2.m2();
        a2.m3();
    }
}

/**
 * 1 = B's m1, A's m2, A's m3, 
 * 2 = B's m1, A's m2, C's m3, 13
 * 3 = A's m1, A's m2, C's m3, 13
 * 4 = 
 */
