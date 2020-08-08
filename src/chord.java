import java.util.Hashtable;

/** Creates chords combinations.
 *  @author Patricia Tse
 */
public class chord {
    /** hashtable of combos **/
    public static Hashtable<String, int[]> chordType = new Hashtable<>() {
        {
            put("major", new int[]{0, 4, 7});
            put("minor", new int[]{0, 3, 7});
            put("sus2", new int[]{0, 2, 7});
            put("sus4", new int[]{0, 5, 7});
            put("7", new int[]{0, 4, 7, 10});
            put("m7", new int[]{0, 3, 7, 10});
            put("maj7", new int[]{0, 4, 7, 11});
            put("mM7", new int[]{0, 3, 7, 11});
            put("6", new int[]{0, 4, 7, 9});
            put("m6", new int[]{0, 3, 7, 9});
            put("6/9", new int[]{0, 4, 7, 9, 14});
            put("5", new int[]{0, 7});
            put("9", new int[]{0, 4, 7, 10, 14});
            put("m9", new int[]{0, 3, 7, 10, 14});
            put("maj9", new int[]{0, 4, 7, 11, 14});
            put("add2", new int[]{0, 2, 4, 7});
            put("add9", new int[]{0, 4, 7, 14});
            put("dim", new int[]{0, 3, 6});
            put("dim7", new int[]{0, 3, 6, 9});
            put("m7b5", new int[]{0, 3, 6, 10});
            put("aug", new int[]{0, 4, 8});
            put("aug7", new int[]{0, 4, 8, 10});
        }
    };

    /** Converts NOTE into int equivalent. */
    public static int convert(String note) {
        int octave = 0;
        if (note.length() == 3) {
            octave = ((Integer.parseInt(note.substring(2)) - 3) * 12);
            switch (note.substring(0, 2)) {
                case "C#":
                    return 49 + octave;
                case "D#":
                    return 51 + octave;
                case "F#":
                    return 54 + octave;
                case "G#":
                    return 56 + octave;
                case "A#":
                    return 58 + octave;
            }
        } else {
            octave = ((Integer.parseInt(note.substring(1)) - 3) * 12);
            switch (note.charAt(0)) {
                case 'C':
                    return 48 + octave;
                case 'D':
                    return 50 + octave;
                case 'E':
                    return 52 + octave;
                case 'F':
                    return 53 + octave;
                case 'G':
                    return 55 + octave;
                case 'A':
                    return 57 + octave;
                case 'B':
                    return 59 + octave;
            }
        }
        return 0;
    }

    /** returns int[] array combo of CHORD. **/
    public static int[] getChord(String chord) {
        return chordType.get(chord);
    }

}
