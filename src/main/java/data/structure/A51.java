package data.structure;

import java.io.PrintWriter;
import java.util.Stack;

import common.FastScanner;

public class A51 {
    public static void main(String[] args) {
        // load input
        FastScanner scanner = new FastScanner();
        int Q = scanner.nextInt();
        int[] queryTypes = new int[Q + 1];
        String[] bookTitles = new String[Q + 1];
        for (int i = 1; i <= Q; i++) {
            int queryType = scanner.nextInt();
            queryTypes[i] = queryType;
            if (queryType == 1) {
                bookTitles[i] = scanner.next();
            }
        }
        // output result
        Stack<String> stack = new Stack<>();
        PrintWriter writer = new PrintWriter(System.out);
        for (int i = 1; i <= Q; i++) {
            if (queryTypes[i] == 1) {
                stack.push(bookTitles[i]);
            }
            if (queryTypes[i] == 2) {
                writer.println(stack.peek());                           
            }
            if (queryTypes[i] == 3) {
                stack.pop();
            }
        }
        writer.flush();
    }
}