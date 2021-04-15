import java.awt.*;
import javax.swing.*;

public class Animate {
    int x = 1;
    int y = 1;
    public static void main(String[] args) {
        Animate gui = new Animate();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(500, 270);
        frame.setVisible(true);

        // Won't disappear with the increments of x & y
        for (int v = 0; v < 124; v++, x++, y++) {
            //
            x++;
            //
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception exception) {}
        }
    }

    class MyDrawPanel extends JPanel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            //
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 250);
            //

            //
            g.setColor(Color.blue);
            g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
            //
        }
    }
}