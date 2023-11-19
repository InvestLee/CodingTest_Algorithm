import java.io.*;
import java.util.*;

//백준 1783 병든 나이트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        if(n == 1) result = 1;
        if(n == 2) result = Math.min(4,(m+1)/2);
        if(n >= 3){
            if(m >= 7) result = m - 2;
            else result = Math.min(4, m);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}