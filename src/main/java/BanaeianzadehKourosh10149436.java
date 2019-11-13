import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(new Scanner(new File(args[0])));
        boolean result = algorithm.compute();

        if (result) {
            System.out.println("YES, target symbol can be formed");
        } else {
            System.out.println("NO, target symbol can NOT be formed");
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
        return encodings[0][input.length - 1].hasTarget(target);
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

    public void printArray() {
        System.out.println(Arrays.stream(encodings).map(encodings1 -> "[" + Arrays.stream(encodings1).map(
            encoding -> encoding == null ? " " : encoding.toString()).collect(Collectors.joining(",")) + "]").collect(Collectors.joining("\n")));
    }

    /**
     * @author kourosh
     * @since 2019-11-06
     */
    public static class Encoding {
        public static int alphabetSize;
        private static String[] encodingToString;
        private int encoding = 0;

        public Encoding() {
        }

        public Encoding(int encoding) {
            this.encoding = encoding;
        }

        public static void initialize(int alphabetSize) {
            Encoding.alphabetSize = alphabetSize;

            encodingToString = new String[(int) Math.pow(2, alphabetSize)];
            for (int encoding = 0; encoding < Math.pow(2, alphabetSize); encoding++) {
                Encoding encodingObject = new Encoding(encoding);

                StringBuilder builder = new StringBuilder();
                for (int alphabet = 0; alphabet < alphabetSize; alphabet++) {
                    if (encodingObject.hasTarget(alphabet)) {
                        builder.append(alphabet).append(",");
                    }
                }
                if (builder.length() > 1) {
                    builder.deleteCharAt(builder.length() - 1);
                }
                builder.insert(0, "{");
                builder.append("}");
                encodingToString[encoding] = builder.toString();
            }
        }

        public static Encoding intToEncoding(int integer) {
            return new Encoding((int) Math.pow(2, integer));
        }

        @Override

        public String toString() {
            return encodingToString[encoding];
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
            if (encoding == Math.pow(2, alphabetSize) - 1) {
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

            int size = (int) Math.pow(2, Encoding.alphabetSize);
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
        //    static {
        //        for (int i = 0; i < 16; i++) {
        //            for (int j = 0; j < 16; j++) {
        //                additionLookup[i][j] = addSlow(new Encoding(i),new Encoding(j));
        //            }
        //        }
        //    }

    }
}
