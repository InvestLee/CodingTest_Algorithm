import java.io.*;
import java.util.*;

//1312 소수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int result = a % b;

        for(int i = 0; i < n-1; i++){
            result *= 10;
            result %= b;
        }

        bw.write(result*10/b+"");
        bw.flush();
        bw.close();
        br.close();
    }
}