import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Key event listener for chords.
 *  @author Patricia Tse
 */
public class KeyListenerer extends JPanel{
    /** Creates event listener and makes sure to focus. */
    public KeyListenerer() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }

    /** Overide keylistener so plays chord. */
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyChar()) {
                case 'q':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("major", chord.convert(GUI.startingNote), 10);
                    break;
                case 'w':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("minor", chord.convert(GUI.startingNote), 10);
                    break;
                case 'e':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("sus2", chord.convert(GUI.startingNote), 10);
                    break;
                case 'r':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("sus4", chord.convert(GUI.startingNote), 10);
                    break;
                case 't':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("7", chord.convert(GUI.startingNote), 10);
                    break;
                case 'y':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("m7", chord.convert(GUI.startingNote), 10);
                    break;
                case 'u':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("maj7", chord.convert(GUI.startingNote), 10);
                    break;
                case 'i':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("mM7", chord.convert(GUI.startingNote), 10);
                    break;
                case 'o':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("6", chord.convert(GUI.startingNote), 10);
                    break;
                case 'p':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("m6", chord.convert(GUI.startingNote), 10);
                    break;
                case 'a':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("6/9", chord.convert(GUI.startingNote), 10);
                    break;
                case 's':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("5", chord.convert(GUI.startingNote), 10);
                    break;
                case 'd':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("9", chord.convert(GUI.startingNote), 10);
                    break;
                case 'f':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("maj9", chord.convert(GUI.startingNote), 10);
                    break;
                case 'g':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("add2", chord.convert(GUI.startingNote), 10);
                    break;
                case 'h':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("add9", chord.convert(GUI.startingNote), 10);
                    break;
                case 'j':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("dim", chord.convert(GUI.startingNote), 10);
                    break;
                case 'k':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("dim7", chord.convert(GUI.startingNote), 10);
                    break;
                case 'l':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("m7b5", chord.convert(GUI.startingNote), 10);
                    break;
                case 'z':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("aug", chord.convert(GUI.startingNote), 10);
                    break;
                case 'x':
                    GUI.clear();
                    MiniMiniMusicApp.playChord("aug7", chord.convert(GUI.startingNote), 10);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
