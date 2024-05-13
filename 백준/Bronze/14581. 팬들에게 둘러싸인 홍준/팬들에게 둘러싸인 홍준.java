import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String k = ":fan::fan::fan:\n" +
                ":fan::jihyeong::fan:\n" +
                ":fan::fan::fan:";

        k = k.replaceFirst("jihyeong", br.readLine());

        System.out.println(k);
        br.close();
    }
}