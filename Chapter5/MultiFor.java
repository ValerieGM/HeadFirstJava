public class MultiFor {
    public static void main(String[] args) {
        for (int x = 0; x < 4; x++) {
            for (int y = 4; y > 2; y--) {
                System.out.println(x + " " + y);
            }

            // Skips 1 instead of 2 i put before 'y' loop
            if (x == 1) {
                x++;
            }
        }
    }
}
