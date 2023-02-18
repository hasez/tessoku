package graph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import common.FastScanner;
/**
 * 深さ優先探索 Depth First Seach
 * 計算量 O(N + M)
 */
public class A62 {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int M = fs.nextInt();
        int[] A = new int[M + 1];
        int[] B = new int[M + 1];

        // 隣接リスト作成 各要素に連結している要素を積み上げ
        List<List<Integer>> adjacentList = new ArrayList<>(N + 1);
        adjacentList.add(null);
        for (int i = 1; i <= N; i++) {
            adjacentList.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            A[i] = fs.nextInt();
            B[i] = fs.nextInt();
            adjacentList.get(A[i]).add(B[i]);
            adjacentList.get(B[i]).add(A[i]);
        }
        boolean[] visited = new boolean[N + 1];
        // 要素 1から調査
        (new A62()).dfs(1, adjacentList, visited);

        String result = "The graph is connected."; 
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result = "The graph is not connected.";
                break;
            }
        }
        PrintWriter output = new PrintWriter(System.out);
        output.println(result);
        output.flush();
    }
    private void dfs(int position, List<List<Integer>> adjacentList, boolean[] visited) {
        visited[position] = true;
        // 次に行く場所を探す
        List<Integer> neighborhoods = adjacentList.get(position);
        for (int neighborhood : neighborhoods) {
            if (!visited[neighborhood]) {
                dfs(neighborhood, adjacentList, visited);
            }
        }
    }
}