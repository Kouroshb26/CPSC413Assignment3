import java.util.Arrays;
import java.util.stream.Collectors;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author kourosh
 * @since 2019-11-06
 */
public class Algorithm {

    Encoding[][] encodings;
    String input;
    int inputLength;

    public static void main(String[] args) {
        String input = "cbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcabaacbbdcbacbcbabacbcdbacbabadbacbcbacbacbcabacbcabacbcbcabacbcaba";
        Algorithm algorithm = new Algorithm(input);
        System.out.println("Input size is "+input.length());

        long start = System.currentTimeMillis();
        if (algorithm.compute()) {
            System.out.println("YES we can compute c");
        } else {
            System.out.println("NO we can't compute c");
        }
        long end = System.currentTimeMillis();

        System.out.println("Time in milliseconds: "+ (end-start));

//        algorithm.printArray();
    }

    public Algorithm(String input) {
        this.input = input;
        this.inputLength = input.length();
        encodings = new Encoding[inputLength][inputLength];
    }

    public boolean compute() {
        int end;
        for (int length = 0; length < inputLength; length++) {
            for (int start = 0; start < inputLength; start++) {
                end = start + length;
                if (end >= inputLength) {
                    break;
                }
                compute(start, end);
            }
        }

        return encodings[0][inputLength - 1].hasC();
    }

    private void compute(int start, int end) {
        Encoding answer = new Encoding();
        if (start == end) {
            answer.addCharacter(input.charAt(start));
        } else if (end < start) {
            return;
        } else {
            for (int middle = start; middle < end; middle++) {
                answer.addEncoding(Add.add(encodings[start][middle], encodings[middle + 1][end]));
                if (answer.isFull()){
                    break;
                }
            }

        }
        encodings[start][end] = answer;
    }

    public void printArray() {
        System.out.println(Arrays.stream(encodings).map(encodings1 -> "["+ Arrays.stream(encodings1).map(
            encoding -> encoding == null? "null":encoding.toString()).collect(Collectors.joining(","))+"]").collect(Collectors.joining("\n")));
    }
}
