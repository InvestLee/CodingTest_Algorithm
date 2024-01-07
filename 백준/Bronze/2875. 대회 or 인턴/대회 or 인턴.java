import java.io.*;
import java.util.*;

//2875 대회 or 인턴
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;
        while(n >= 2 && m >= 1 && m+n >= 3+k){
            n -= 2;
            m -= 1;
            result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}