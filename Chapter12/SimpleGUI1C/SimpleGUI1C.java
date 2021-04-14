package SimpleGUI1C;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGUI1C gui = new SimpleGUI1C();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change Colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        /*
         * When the user clicks, tell the frame to repaint() itself. That means
         * paintComponent() is called on every widget in the frame!
         */
        frame.repaint();
    }
}
