package common;

import java.io.IOException;
import java.io.InputStream;

/**
 * 標準入力に、任意の文字列を入力する
 */
public class StandardInputSnatcher extends InputStream {
    private StringBuilder builder = new StringBuilder();
    private static String lineSeparator = System.getProperty("line.separator");

    /**
     * 文字列を入力する。都度改行する。
     * @param s 入力する文字列
     */
    public void append(String s) {
        builder.append(s);
        builder.append(lineSeparator);
    }

    @Override
    public int read() throws IOException {
        if (builder.length() == 0) {
            return -1;
        } else {
            int c = builder.charAt(0);
            builder.deleteCharAt(0);
            return c;
        }
    }
    
}
