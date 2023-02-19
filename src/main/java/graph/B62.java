package graph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.FastScanner;

/**
 * 深さ優先探索 deep first search
 * Order O(N + M)
 */
public class B62 {
    public static void main(String[] args) {
        // read input
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int M = fs.nextInt();
        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = fs.nextInt();
            B[i] = fs.nextInt();
        }
        // create adjacent List
        List<List<Integer>> adjacentList = new ArrayList<>(N + 1);
        adjacentList.add(null);
        for (int i = 1; i <= N; i++) {
            adjacentList.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            adjacentList.get(A[i]).add(B[i]);
            adjacentList.get(B[i]).add(A[i]);
        }
        // dfs
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> path = new Stack<>();
        path.push(1);
        dfs(1, N, adjacentList, visited, path);

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < path.size(); i++) {
            String separated = (i == 0 ? "" : " ");
            out.printf("%s%d", separated, path.get(i));
        }
        out.flush();
    }

    private static int[] dfs(int position, int goal, 
            List<List<Integer>> adjacentList,
            boolean[] visited,
            Stack<Integer> path) {
        visited[position] = true;
        // reached last vertex.
        if (position == goal) {
            return path
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        }
        for (int next : adjacentList.get(position)) {
            if (!visited[next]) {
                path.push(next);
                int[] result = dfs(next, goal, adjacentList, visited, path);
                if (result != null) {
                    return result;
                }
                path.pop();
            }
        }
        return null;
    }
}
