import java.io.*;
import java.util.*;

//백준 11441 합 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            arr[i] += arr[i-1];
        }

        int m = Integer.parseInt(br.readLine());
        int start, end;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            bw.write(arr[end]-arr[start-1]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}