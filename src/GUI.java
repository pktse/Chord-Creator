import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import java.util.ArrayList;

/** GUI keyboard.
 *  @author Patricia Tse
 */
public class GUI implements ActionListener {
    /** All buttons for keys. **/
    public static ArrayList<JButton> buttons = new ArrayList<>();
    /** White keys. **/
    private static String[] notes = new String[]{"C", "D", "E", "F", "G", "A", "B"};
    /** Black keys. **/
    private static String[] notes2 = new String[]{"C#", "D#", "F#", "G#", "A#"};
    /** All keys. **/
    private static String[] allNotes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    /** Starting note. **/
    public static String startingNote = "C3";
    /** Starting octave. **/
    public static String startingOctave = "3";
    /** Starting key. **/
    public static String startingKey = "C";

    public static KeyListenerer listener;

    /** Creates GUI, assuming ARGS empty. **/
    public static void main (String[] args) {
        GUI gui = new GUI();
        gui.go();
    }

    /** Creates GUI, creates frames and buttons. **/
    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        listener = new KeyListenerer();
        frame.add(listener);

        frame.setSize(1300,270);
        panel.setLayout(null);
        JComboBox start = new JComboBox(allNotes);
        JComboBox octaves = new JComboBox(new String[]{"2", "3", "4", "5"});
        start.addActionListener(this);
        octaves.addActionListener(this);
        start.setBounds(10, 10, 100, 40);
        octaves.setBounds(13, 10, 100, 40);
        panel.add(start);
        panel.add(octaves);

        int shift, white, black;
        shift = white = black = 0;
        for (int i = 0; i < 49; i++) {
            JButton btn = new JButton(allNotes[i % 12] + ((i / 12) + 2));
            btn.setOpaque(true);
            btn.addActionListener(this);
            btn.setPreferredSize(new Dimension(40,80));
            btn.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            Dimension size = btn.getPreferredSize();
            int check = i % 12;
            if (check == 1 || check == 3 || check == 6 || check == 8 || check == 10) {
                if ((check == 6) || (check == 1)) {
                    shift += 1;
                }
                btn.setBackground(Color.black);
                btn.setForeground(Color.white);
                btn.setBounds((42 * (black + shift) - 21) + 20, 60, size.width, size.height);
                black += 1;
            } else {
                btn.setBackground(null);
                btn.setForeground(Color.black);
                btn.setBounds((42 * white) + 20, 150, size.width, size.height);
                white += 1;
            }
            buttons.add(btn);
            panel.add(btn);
        }
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    /** Makes NOTE red when clicked. **/
    public static void click(String note) {
        for (JButton btn: buttons) {
            if (btn.getText().equals(note)) {
                btn.setBackground(Color.RED);
            }
        }
    }

    /** Resets NOTE back to og color. **/
    public static void unclick(String note) {
        for (JButton btn: buttons) {
            if (btn.getText().equals(note)) {
                boolean sharp = false;
                for (String noted: notes2) {
                    if (note.substring(0,2).equals(noted)) {
                        sharp = true;
                    }
                }
                if (sharp) {
                    btn.setBackground(Color.BLACK);
                    btn.setForeground(Color.WHITE);
                } else {
                    btn.setForeground(Color.black);
                    btn.setBackground(null);
                }
            }
        }
    }

    /** Gets String[] of allnotes. **/
    public static String[] getAll() {
        return allNotes;
    }

    /** Finds JButton with NOTE. **/
    public static JButton find(String note) {
        for (JButton btn: buttons) {
            if (btn.getText().equals(note)) {
                return btn;
            }
        }
        return null;
    }

    /** When key pressed EVENT. **/
    public void actionPerformed(ActionEvent event) {
        try {
            JComboBox cb = (JComboBox) event.getSource();
            if (isInteger((String) cb.getSelectedItem())) {
                startingNote = startingKey + (String) cb.getSelectedItem();
            } else {
                startingNote = (String) cb.getSelectedItem() + startingOctave;
            }
            GUI.listener.requestFocusInWindow();
        } catch (ClassCastException ex) {}
        try {
            String note = ((JButton) event.getSource()).getText();
            int noteNum = chord.convert(note);
            clear();
            click(getAll()[noteNum % 12] + (noteNum / 12 - 1));
            MiniMiniMusicApp.play(noteNum, 5);
            GUI.listener.requestFocusInWindow();
        }
        catch (java.lang.ClassCastException ex) {}
    }

    /** Clears all clicked buttons. **/
    public static void clear() {
        for (JButton btn: buttons) {
            unclick(btn.getText());
        }
        return;
    }

    /** returns true iff INPUT represents an integer. */
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}

