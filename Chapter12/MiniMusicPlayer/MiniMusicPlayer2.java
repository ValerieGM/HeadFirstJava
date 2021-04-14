package MiniMusicPlayer;

import javax.sound.midi.*;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/*
* 
*/
public class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            /*
             * Register for events with the sequencer. The event registration method takes
             * the listener AND an int array representing the list of ControllerEvents you
             * want. We want only one event, #127.
             */
            int[] eventsIWant = { 127 };
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int v = 0; v < 61; v++) {
                track.add(makeEvent(144, 1, v, 100, v));

                /*
                 * Here’s how we pick up the beat -- we insert our OWN ControllerEvent (176 says
                 * the event type is ControllerEvent) with an argument for event number #127.
                 * This event will do NOTHING! We put it in JUST so that we can get an event
                 * each time a note is played. In other words, its sole purpose is so that
                 * something will fire that WE can listen for (we can’t listen for NOTE ON/OFF
                 * events). Note that we’re making this event happen at the SAME tick as the
                 * NOTE ON. So when the NOTE ON event happens, we’ll know about it because OUR
                 * event will fire at the same time.
                 */
                track.add(makeEvent(176, 1, 127, 0, v));

                track.add(makeEvent(128, 1, v, 100, v));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * The event handler method (from the Controller- Event listener interface).
     * Each time we get the event, we’ll print “la” to the command-line.
     */
    public void controlChange(ShortMessage event) {
        System.out.println("la");
    }

    public static MidiEvent makeEvent(int command, int channel, int data1, int data2, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, data1, data2);
            event = new MidiEvent(a, tick);
        } catch (Exception exception) {
        }

        return event;
    }
}
