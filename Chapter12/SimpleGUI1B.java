import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGUI1B gui = new SimpleGUI1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Click me");

        /*
         * register your interest with the button. This says to the button, “Add me to
         * your list of listeners”. The argument you pass MUST be an object from a class
         * that implements ActionListener!!
         */
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    /*
     * Implement the ActionListener interface’s actionPerformed() method.. This is
     * the actual event-handling method!
     */
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked");
    }
}
