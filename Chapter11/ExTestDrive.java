class MyEx extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;}

public class ExTestDrive {
    static void doRisky(String t) throws MyEx {
        System.out.print("h");

        if ("yes".equals(t)) {
            throw new MyEx();
        }
        // Why here.......
        // System.out.print("r");
    }
    public static void main(String[] args) {
        String test = args[0];

        try {
            System.out.print("t");
            doRisky(test);
            // And not here???????
            System.out.print("r");
            System.out.print("o");

        } catch(MyEx exception) {
            System.out.print("a");
        } finally {
            System.out.print("w");
            System.out.println("s");
        }
    }
}
