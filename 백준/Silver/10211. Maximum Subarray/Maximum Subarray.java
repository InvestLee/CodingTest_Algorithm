import java.io.*;
import java.util.*;

//10211 Maximum Subarray
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n, result;
        int[] arr;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                arr[i] += arr[i-1];
            }

            result = -1001;
            for(int i = 0; i <= n; i++){
                for(int j = i+1; j <= n; j++){
                    result = Math.max(result, arr[j]-arr[i]);
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
}
