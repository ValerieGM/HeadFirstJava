import java.awt.*;
import javax.swing.*;

public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int v = 0; v < 130; v++) {
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(50);
            } catch (Exception exception) {
            }
        }
    }

    /*
     * MyDrawPanel is now an inner class because it needs to continually update x
     * and y
     */
    class MyDrawPanel extends JPanel {
        /**
        *
        */
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            /*
             * The code below adds two lines at the start of the method: one to set the
             * color to white (the background color of the drawing panel) and the other to
             * fill the entire panel rectangle with that color
             */
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }
}
