package graph;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import common.FastScanner;

public class B63 {
    public static void main(String[] args) {
        // input
        FastScanner scanner = new FastScanner();
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int sy = scanner.nextInt();
        int sx = scanner.nextInt();
        int gy = scanner.nextInt();
        int gx = scanner.nextInt();
        char[][] c = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String row = scanner.next();
            for (int j = 1; j <= C; j++) {
                c[i][j] = row.charAt(j - 1);
            }
        }

        Point start = new Point(sy, sx, C);
        Point goal = new Point(gy, gx, C);

        // create graph
        List<List<Integer>> graph = new ArrayList<>(R * C + 1);
        graph.add(null);
        for (int i = 1; i <= R * C; i++) {
            graph.add(new ArrayList<>());
        }
        // 横方向 [ (i, j) と (i, j + 1) ]
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C - 1; j++) {
                Point base = new Point(i, j, C);
                Point next = new Point(i, j + 1, C);
                if (c[i][j] == '.' && c[i][j + 1] == '.') {
                    graph.get(base.intValue()).add(next.intValue());
                    graph.get(next.intValue()).add(base.intValue());
                }
            }
        }
        // 縦方向 [ (i, j) と (i + 1, j) ]
        for (int i = 1; i <= R - 1; i++) {
            for (int j = 1; j <= C; j++) {
                Point base = new Point(i, j, C);
                Point next = new Point(i + 1, j, C);
                if (c[i][j] == '.' && c[i + 1][j] == '.') {
                    graph.get(base.intValue()).add(next.intValue());
                    graph.get(next.intValue()).add(base.intValue());
                }
            }
        }
        // 幅優先探索 BFS breadth-first-search
        /*
         * 3つの状態で管理する
         * 発見済・訪問済 dist[v] != -1 / queue から取り出される
         * 発見済・未訪問 queue に入れる
         * 未発見・未訪問 dist[v] が -1
         */
        int[] dist = new int[R * C + 1]; // dist[v]: 頂点vまでのstep数を保存(未発見は-1)
        Arrays.fill(dist, -1); // 初期化
        Queue<Integer> queue = new ArrayDeque<>(); // 発見済・未訪問な頂点

        dist[start.intValue()] = 0;
        queue.add(start.intValue());

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int av : graph.get(pos)) {
                if (dist[av] == -1) {
                    dist[av] = dist[pos] + 1;
                    queue.add(av);
                }
            }
        }
        // answer
        PrintWriter out = new PrintWriter(System.out);
        out.println(dist[goal.intValue()]);
        out.flush();
    }
}

class Point {
    int y = -1;
    int x = -1;
    int C = -1;
    int vertex = -1;

    Point(int y, int x, int C) {
        this.y = y;
        this.x = x;
        this.C = C;
    }

    boolean equals(Point p) {
        return this.y == p.y && this.x == p.x;
    }

    int intValue() {
        if (this.vertex == -1) {
            this.vertex = (y - 1) * C + x;
        }
        return this.vertex;
    }
}