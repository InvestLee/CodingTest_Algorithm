import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long result = gcd(Math.max(a,b),Math.min(a,b));

        for(int i = 0; i < result; i++) bw.write("1");
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b){
        long temp;
        while(b > 0){
            temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }
}
