import java.io.*;
import java.util.*;

//2435 기상청 인턴 신현수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temper = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) temper[i] = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;
        int temp;
        for(int i = 0; i <= n-k; i++){
            temp = 0;
            for(int j = 0; j < k; j++){
                temp += temper[i+j];
            }
            if(temp > result) result = temp;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}