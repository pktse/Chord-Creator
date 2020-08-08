import javax.sound.midi.*;
public class MusicTest1 {

    public void play() throws javax.sound.midi.MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("We got a sequencer"); }

    public static void main(String[] args) throws javax.sound.midi.MidiUnavailableException {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
