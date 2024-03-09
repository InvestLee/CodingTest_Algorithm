import java.io.*;
import java.util.*;

//10158 개미
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int x = w - Math.abs(w - (p + t) % (w * 2));
        int y = h - Math.abs(h - (q + t) % (h * 2));
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}