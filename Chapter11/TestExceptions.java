
class ScaryException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}

public class TestExceptions {

    static void doRisky(String test) throws ScaryException {
        System.out.println("Start risky.");
        if ("yes".equals(test))
            throw new ScaryException();
        System.out.println("End risky.");
        return;
    }

    public static void main(String[] args) {
        String test = "no";

        try {
            System.out.println("Start try.");
            doRisky(test);
            System.out.println("End try.");
        } catch (ScaryException exception) {
            System.out.println("Scary Exception.");
        } finally {
            System.out.println("Finally.");
        }
        System.out.println("End of main.");
    }
}

/*
 * YES::
 * Start try. 
 * Start risky. 
 * Scary Exception. 
 * Finally. 
 * End of main.
 */

 /*
 * NO::
 * Start try.
 * Start risky.
 * End risky.
 * End try.
 * Finally.
 * End of main.
 */