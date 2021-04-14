package MiniMusicPlayer;

import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;

public class MiniMusicPlayer3 {
    static MyDrawPanel drawPanel;
    static JFrame frame = new JFrame("My First Music Video");

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        drawPanel = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(drawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(drawPanel, new int[] { 127 });

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int random = 0;
            for (int v = 0; v < 60; v++) {
                random = (int) (Math.random() * 50);

                track.add(makeEvent(144, 1, random, 100, v));
                track.add(makeEvent(176, 1, 127, 0, v));
                track.add(makeEvent(128, 1, random, 100, v + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int command, int channel, int data1, int data2, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, data1, data2);
            event = new MidiEvent(a, tick);
        } catch (Exception exception) {
        }

        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        /**
        *
        */
        private static final long serialVersionUID = 1L;
        /*
         * We set a flag to false, and we’ll set it to true only when we get an event.
         */
        boolean message = false;

        public void controlChange(ShortMessage event) {
            message = true;
            repaint();
        }

        public void paintComponent(Graphics g) {

            /*
             * We have to use a flag because OTHER things might trigger a repaint(), and we
             * want to paint ONLY when there’s a ControllerEvent
             */
            if (message) {
                // Graphics2D g2 = (Graphics2D) g;
                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, width, height);
                message = false;
            }
        }
    }
}