package graph;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import common.FastScanner;

/**
 * 幅優先探索 BFS breadth-first-search
 */
public class A63 {
    public static void main(String[] args) {
        // load input
        FastScanner sc = new FastScanner();
        int N = (int) sc.nextLong();
        int M = (int) sc.nextLong();
        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = (int) sc.nextLong();
            B[i] = (int) sc.nextLong();
        }
        // create graph
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        graph.add(null);
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }
        /*
         * 3つの状態で管理する
         * 発見済・訪問済 dist[v] != -1
         * 発見済・未訪問 queue に入れる
         * 未発見・未訪問 dist[v] が -1
         */
        int[] dist = new int[N + 1]; // dist[v]: 頂点vまでのstep数を保存(未発見は-1)
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>(); // 発見済・未訪問な頂点

        dist[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int av : graph.get(pos)) { // av: Adjacent Vertices
                // 新たな頂点(未発見) av のstep数を登録して、発見済に
                if (dist[av] == -1) {
                    dist[av] = dist[pos] + 1;
                    queue.add(av);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= N; i++) {
            out.println(dist[i]);
        }
        out.flush();
    }
}