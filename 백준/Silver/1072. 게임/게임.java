import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = 100*y/x;
        long start = 1;
        long end = x;
        long mid, cal;

        if(z >= 99) end = -1;
        else{
            while(start < end){
                mid = (start+end) / 2;
                cal = 100 * (y+mid) / (x+mid);
                if (cal > z) end = mid;
                else start = mid + 1;
            }
        }

        bw.write(end+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
