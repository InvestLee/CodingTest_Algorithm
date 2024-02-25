import java.io.*;
import java.util.*;

//5347 LCM
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long result;
        long a, b, temp;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            if(a<b){
                temp = a;
                a = b;
                b = temp;
            }
            result = a * b / gcd(a,b);
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static long gcd(long big, long small){
        if(big % small == 0) return small;
        return gcd(small, big % small);
    }
}