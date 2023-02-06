import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];
        long area1 = 0L, area2 = 0L;

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];

        for(int i = 0; i < n; i++){
            area1 += x[i] * y[i+1];
            area2 += x[i+1] * y[i];
        }
        System.out.printf("%.1f",(Math.abs(area1-area2))/(2.0));
    }
}