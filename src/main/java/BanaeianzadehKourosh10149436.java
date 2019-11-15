import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Kourosh Banaeianzadeh
 * @id 10149436
 * @since 2019-11-06
 */
public class BanaeianzadehKourosh10149436 {

    Encoding[][] encodings;
    int[] input;
    int target;

    public BanaeianzadehKourosh10149436(Scanner scanner) {
        Encoding.initialize(scanner.nextInt());
        scanner.nextLine();

        this.target = scanner.nextInt();
        scanner.nextLine();

        int[][] additionRule = new int[Encoding.alphabetSize][Encoding.alphabetSize];
        for (int i = 0; i < additionRule.length; i++) {
            for (int j = 0; j < additionRule[i].length; j++) {
                additionRule[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        Add.initialize(additionRule);

        char[] inputArray = scanner.nextLine().toCharArray();
        this.input = IntStream.range(0, inputArray.length).map(i -> inputArray[i] - '0').toArray();
        encodings = new Encoding[input.length][input.length];
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("USAGE: ./addition filename.in");
        }
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
            algorithm.compute();
        }
    }

    public boolean compute() {
        int end;
        for (int length = 0; length < input.length; length++) {
            for (int start = 0; start < input.length; start++) {
                end = start + length;
                if (end >= input.length) {
                    break;
                }
                compute(start, end);
            }
        }

        boolean result = encodings[0][input.length - 1].hasTarget(target);
        if (result) {
            System.out.println("YES, target symbol can be formed");
        } else {
            System.out.println("NO, target symbol can NOT be formed");
        }
        return result;
    }

    private void compute(int start, int end) {
        Encoding answer = new Encoding();
        if (start == end) {
            answer.addEncoding(Encoding.intToEncoding(input[start]));
        } else {
            for (int middle = start; middle < end; middle++) {
                answer.addEncoding(Add.add(encodings[start][middle], encodings[middle + 1][end]));
                if (answer.isFull()) {
                    break;
                }
            }
        }
        encodings[start][end] = answer;
    }

    /**
     * @author kourosh
     * @since 2019-11-06
     */
    public static class Encoding {
        public static int alphabetSize;
        private static int FULL_ENCODING;

        private int encoding = 0;

        public Encoding() {
        }

        public Encoding(int encoding) {
            this.encoding = encoding;
        }

        public static void initialize(int alphabetSize) {
            Encoding.alphabetSize = alphabetSize;
            FULL_ENCODING = (int) (Math.pow(2, alphabetSize) - 1);
        }

        public static Encoding intToEncoding(int integer) {
            return new Encoding((int) Math.pow(2, integer));
        }

        public List<Integer> indices() {
            ArrayList<Integer> list = new ArrayList<>(alphabetSize);

            for (int i = 0; i < alphabetSize; i++) {
                if (((encoding >> i) & 0x1) == 0x1) {
                    list.add(i);
                }
            }
            return list;
        }

        public boolean isFull() {
            if (encoding == FULL_ENCODING) {
                return true;
            } else {
                return false;
            }
        }

        public void addEncoding(Encoding encode) {
            encoding = encoding | encode.encoding;
        }

        public int getEncoding() {
            return encoding;
        }

        public void addInt(int encoding2) {
            encoding = encoding | encoding2;
        }

        public boolean hasTarget(int target) {
            return ((encoding >> target) & 0x1) == 0x1;
        }
    }

    /**
     * @author kourosh
     * @since 2019-11-06
     */
    public static class Add {
        private static int[][] additionRule;
        private static Encoding[][] additionLookup;

        public static void initialize(int[][] additionRule) {
            Add.additionRule = additionRule;

            int size = Encoding.FULL_ENCODING + 1;
            additionLookup = new Encoding[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    additionLookup[i][j] = addSlow(new Encoding(i), new Encoding(j));
                }
            }
        }

        private static Encoding addSlow(Encoding first, Encoding second) {
            Encoding answer = new Encoding();
            for (int i : first.indices()) {
                for (int j : second.indices()) {
                    answer.addInt(0x1 << additionRule[i][j]);
                }
            }
            return answer;
        }

        public static Encoding add(Encoding first, Encoding second) {
            return additionLookup[first.getEncoding()][second.getEncoding()];
        }
    }
}
