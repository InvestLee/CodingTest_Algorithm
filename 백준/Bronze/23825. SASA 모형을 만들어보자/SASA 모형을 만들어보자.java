import java.io.*;
import java.util.*;

//23825 SASA 모형을 만들어보자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) / 2;
        int m = Integer.parseInt(st.nextToken()) / 2;
        bw.write(Math.min(n,m)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}