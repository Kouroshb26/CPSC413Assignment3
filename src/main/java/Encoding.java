import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kourosh
 * @since 2019-11-06
 */
public class Encoding {
    private int encoding = 0;
    private static Map<Integer, String> encodingToString = new HashMap<>();

    static {
        //setup
        for (int i = 0; i < 16; i++) {
            StringBuilder builder = new StringBuilder("{");
            if ((i & 0x1) == 1) {
                builder.append("a,");
            }
            if ((i & 0x2) == 2) {
                builder.append("b,");
            }
            if ((i & 0x4) == 4) {
                builder.append("c,");
            }
            if ((i & 0x8) == 8) {
                builder.append("d,");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("}");
            encodingToString.put(i, builder.toString());
        }
    }

    public Encoding() {
    }

    public Encoding(int encoding) {
        if (encoding > 15) {
            throw new RuntimeException("Encoding too big");
        }
        this.encoding = encoding;
    }

    private int characterToIndex(char c) {
        return c - 'a';
    }

    @Override
    public String toString() {
        return encodingToString.get(encoding);
    }

    public List<Integer> indices() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if ((encoding & (0x1 << i)) == (0x1 << i)) {
                list.add(i);
            }
        }
        return list;
    }

    public void addCharacter(char c) {
        encoding = encoding | (0x1 << characterToIndex(c));
    }

    public boolean isFull() {
        if (encoding == 15) {
            return true;
        } else {
            return false;
        }
    }

    public void addEncoding(Encoding encode) {
        encoding = encoding | encode.encoding;
    }

    public int getEncoding(){
        return encoding;
    }

    public boolean hasC() {
        return (encoding >> 2 & 0x1) == 0x1;
    }
}
