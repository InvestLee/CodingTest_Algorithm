import java.io.*;
import java.util.*;

//백준 19698 헛간 청약
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int result = (w / l) * (h / l);

        bw.write(Math.min(n,result)+"");
        bw.flush();
        br.close();
        bw.close();
    }
}