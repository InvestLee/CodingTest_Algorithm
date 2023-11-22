import java.io.*;
import java.util.*;

//백준 14652 나는 행복합니다~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int row = k / m;
        int col = k % m;

        bw.write(row+" "+col);
        bw.flush();
        br.close();
        bw.close();
    }
}