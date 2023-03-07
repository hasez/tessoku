package graph;

import java.io.PrintWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.FastScanner;

/**
 * ダイクストラ法 Dijkstra's algorithm
 */
public class A64 {
    public static void main(String[] args) {
        // load input
        FastScanner scanner = new FastScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        int[] C = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
            C[i] = scanner.nextInt();
        }
        // create adjacent list
        List<List<SimpleEntry<Integer, Integer>>> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            graph.get(A[i]).add(new SimpleEntry<Integer, Integer>(B[i], C[i]));
            graph.get(B[i]).add(new SimpleEntry<Integer, Integer>(A[i], C[i]));
        }
        // execute dijkstra
        int[] cur = slowDijkstra(graph);

        // print result
        PrintWriter writer = new PrintWriter(System.out);
        for (int i = 1; i <= N; i++) {
            writer.println(cur[i] != Integer.MAX_VALUE ? cur[i] : -1);
        }
        writer.flush();
    }

    /**
     * Slow Dijkstra's algorithm. 
     * O(n^2)
     * @param graph 隣接リスト adjacent-list
     * @return 最短距離配列 頂点 i までの最短距離を表す
     */
    private static int[] slowDijkstra(List<List<SimpleEntry<Integer, Integer>>> graph) {
        // 頂点の数
        int N = graph.size() - 1;
        // fix[i] は 頂点 i の最短距離が決定したかどうかを表す
        boolean[] fix = new boolean[N + 1];
        // cur[i] は 頂点 i までの距離の暫定値を表す
        int[] cur = new int[N + 1];
        Arrays.fill(cur, Integer.MAX_VALUE);

        // 最短距離を更新する
        cur[1] = 0;
        while (true) {
            // 次に確定する頂点 pos を求める
            int pos = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (fix[i] || minDist <= cur[i]) {
                    continue;
                }
                pos = i;
                minDist = cur[i];
            }
            // 次に確定する頂点がない場合、終了
            if (pos == -1) {
                break;
            }
            // pos と隣接する頂点の cur を更新する
            fix[pos] = true;
            for (SimpleEntry<Integer, Integer> next : graph.get(pos)) {
                int num = next.getKey(); // 頂点の番号
                int cost = next.getValue(); // 辺の長さ
                cur[num] = Math.min(cur[num], cur[pos] + cost);
            }
        }
        return cur;
    }
}