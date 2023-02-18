package graph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import common.FastScanner;

public class B61 {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int N = (int) scanner.nextLong();
        int M = (int) scanner.nextLong();

        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = (int) scanner.nextLong();
            B[i] = (int) scanner.nextLong();
        }

        List<List<Integer>> adjacentList = new ArrayList<>(M + 1);
        adjacentList.add(null);
        for (int i = 1; i <= N; i++) {
            adjacentList.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            adjacentList.get(A[i]).add(B[i]);
            adjacentList.get(B[i]).add(A[i]);
        }

        int maxNumOfFriends = -1;
        int studentId = -1;
        for (int i = 1; i <= N; i++) {
            if (maxNumOfFriends < adjacentList.get(i).size()) {
                maxNumOfFriends = adjacentList.get(i).size();
                studentId = i;
            }
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(studentId);
        printWriter.flush();
    }
}
