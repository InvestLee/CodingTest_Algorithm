import java.io.*;
import java.util.*;

//백준 9527 1의 개수 세기
public class Main {

    public static long[] bit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bit = new long[55];
        bit[0] = 1;
        for(int i = 1; i < 55; i++){
            bit[i] = 2 * bit[i-1] + (1L << i);
        }

        long result = getCount(b) - getCount(a - 1);
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static long getCount(long x){
        long result = x & 1;
        int size = (int)(Math.log(x)/Math.log(2));
        for(int i = size; i > 0; i--){
            if((x & (1L << i)) != 0L){
                result += bit[i-1] + (x - (1L << i) + 1);
                x -= (1L << i);
            }
        }
        return result;
    }
}