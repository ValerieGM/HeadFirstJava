public class Output {
    public static void main(String[] args) {
        Output o = new Output();
        o.go();
    }

    // Guess = {12, 15, x = 8}
    // Outpu = {13, 12, x = 6}
    void go() {
        int y = 7;
        for (int x = 1; x < 8; x++) {
            y++;
            if (x > 4) {
                System.out.print(++y + " ");
            }
            if (y > 14) {
                System.out.println(" x = " + x);
                break;
            }
        }
    }
}
