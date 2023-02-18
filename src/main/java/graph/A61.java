package graph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import common.FastScanner;

public class A61 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int N = (int) sc.nextLong();
        int M = (int) sc.nextLong();

        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = (int) sc.nextLong();
            B[i] = (int) sc.nextLong();
        }

        // List<Integer>[] adjacentList = new ArrayList[N + 1];
        List<List<Integer>> adjacentList = new ArrayList<>(N + 1);
        adjacentList.add(null);
        for (int i = 1; i <= N; i++) {
            adjacentList.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            // adjacentList[A[i]].add(B[i]);
            // adjacentList[B[i]].add(A[i]);
            adjacentList.get(A[i]).add(B[i]);
            adjacentList.get(B[i]).add(A[i]);
        }
        PrintWriter output = new PrintWriter(System.out);
        for (int i = 1; i <= N; i++) {
            // output.println(i + ": " + adjacentList[i].toString().replaceFirst("\\[", "{").replaceFirst("\\]", "}"));
            // output.println(i + ": " + adjacentList.get(i).toString().replaceFirst("\\[", "{").replaceFirst("\\]", "}"));
            output.printf("%s: %s\n", i, adjacentList.get(i).toString().replaceFirst("\\[", "{").replaceFirst("\\]", "}"));
        }
        output.flush();
    }
}
