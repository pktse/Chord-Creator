/* Inspired by sound application of Heads First Java */
import javax.sound.midi.*;
import javax.swing.*;
import java.util.ArrayList;


/** Creates music based on midi notes.
 *  @author Patricia Tse
 */
public class MiniMiniMusicApp {
    public static ArrayList<int[]> notes = new ArrayList<>();
    public static ArrayList<String[]> chords = new ArrayList<>();

    /** Plays notes, assumes empty ARGS.*/
    public static void main(String[] args) {
        /* 48 is middle C
         * octave is 12 (13?)
         */
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        GUI gui = new GUI();
        gui.go();
        notes.add(new int[]{48,10});
        notes.add(new int[]{50,5});
        notes.add(new int[]{52,10});
        notes.add(new int[]{48,5});
        notes.add(new int[]{52,10});
        notes.add(new int[]{48,10});
        notes.add(new int[]{52,5});
        chords.add(new String[]{"major", "10"});
        chords.add(new String[]{"sus2", "10"});
        chords.add(new String[]{"sus4", "10"});
        chords.add(new String[]{"major", "10"});
//        playNotes(notes, 0);
//        playChords(chords, 0, 48);
    }

    /** Creates and plays notes from NOTES using I.*/
    public static void playNotes(ArrayList<int[]> notes, int i) {
        try {
            if (i >= notes.size()) {
                return;
            }
            int note = notes.get(i)[0];
            int velocity = notes.get(i)[1];
            GUI.clear();
            play(note, velocity);
            Thread.sleep(velocity * 100);
            playNotes(notes, i + 1);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /** Creates and plays CHORDS from CHORDS using I on NOTE.*/
    public static void playChords(ArrayList<String[]> chords, int i, int note) {
        try {
            if (i >= chords.size()) {
                return;
            }
            String type = chords.get(i)[0];
            int velocity = Integer.parseInt(chords.get(i)[1]);
            GUI.clear();
            playChord(type, note, velocity);
            Thread.sleep(velocity * 100);
            playChords(chords, i + 1, note);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /** Creates and plays chords of TYPE for VELOCITY on NOTE.*/
    public static void playChord(String type, int notes, int velocity) {
        chord chords = new chord();
        int[] combo = chords.getChord(type);
        for (int i: combo) {
            play(i + notes, velocity);
        }
    }

    /** Creates and plays note based on NOTE and VELOCITY.*/
    public static void play(int note, int velocity) {
        /* Notes about midi player:
        *  setMessage(command, channel, data1, data2)
        *       command: 144 = on, 128 = off
        *           192 = change instrument:
        *               channel: current channel
        *               data1: instrument to change to
        *       channel: which instrument playing
        *       data1: note to play
        *       data2: velocity
        *   midiEvent(message, tick):
        *       message: message
        *       tick: time
        * */
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            String[] all = GUI.getAll();
            String newNote = all[note % 12] + (note / 12 - 1);
            GUI.click(newNote);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, velocity);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}