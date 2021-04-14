package MiniMusicPlayer;

import javax.sound.midi.*;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/*
* There’s no event handling or graphics here, just a sequence of 15 notes that go up the scale. 
*/
public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int v = 0; v < 61; v++) {
                track.add(makeEvent(144, 1, v, 100, v));
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
     * The event ‘tick’ for WHEN this message should happen
     */
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
