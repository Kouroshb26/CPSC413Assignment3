import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

/**
 * @author kourosh
 * @since 2019-11-06
 */
public class Encoding {
    private Boolean[] encoding = new Boolean[4];
    private boolean isFull = false;

    private int characterToIndex(char c) {
        return c - 'a';
    }

    public Encoding() {
        Arrays.fill(encoding, Boolean.FALSE);
    }

    @Override
    public String toString() {
        return "{" + IntStream.range(0, encoding.length)
            .filter(index -> encoding[index])
            .mapToObj(index -> Character.toString((char) (index + 'a')))
            .collect(Collectors.joining(",")) + "}";
    }

    public List<Integer> indeces() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < encoding.length; i++) {
            if (encoding[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public void addCharacter(char c) {
        encoding[characterToIndex(c)] = true;
    }

    public boolean isFull() {
        if (isFull) {
            return isFull;
        } else {
            for (int i = 0; i < encoding.length; i++) {
                if (!encoding[i]) {
                    isFull = false;
                    return isFull;
                }
            }
        }
        isFull = true;
        return isFull;
    }

    public void addEncoding(Encoding encode) {
        for (Integer i : encode.indeces()) {
            encoding[i] = true;
        }
    }

    public boolean hasC() {
        return encoding[2];
    }
}
