import java.io.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T, R, C;
    String[] strs;

    public void solve() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            strs = br.readLine().split(" ");
            int tmp1 = Integer.parseInt(strs[0]);
            int tmp2 = Integer.parseInt(strs[1]);

            R = Math.min(tmp1, tmp2);
            C = Math.max(tmp1, tmp2);

            long[] ans = pyramid(R, C);

            bw.write(String.valueOf(ans[0]));
            bw.write(String.valueOf(" "));
            bw.write(String.valueOf(ans[1]));
            bw.newLine();
        }
        bw.close();
    }

    long[] pyramid(int r, int c) throws IOException {
        long white = 0, dark = 0;

        white = 2 * sum2(r) - (2 * sum1(r)) + r;
        white += (c - r) * (r + 2 * sum1(r - 1));

        dark = 2 * (sum2(r) - sum1(r));
        dark += (c - r) * (r + 2 * sum1(r - 1));

        return new long[]{white, dark};
    }

    long sum1(long n) {
        return (1 + n) * n / 2;
    }

    long sum2(long n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }
}