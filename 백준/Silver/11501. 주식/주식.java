import java.io.*;
import java.util.*;

//11501 주식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] value;
        StringTokenizer st;

        int n, maxValue;
        long result;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            result = 0;
            value = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) value[i] = Integer.parseInt(st.nextToken());
            maxValue = value[n-1];
            for(int i = n-2; i >= 0; i--){
                if(value[i] <= maxValue) result += maxValue - value[i];
                else maxValue = value[i];
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}