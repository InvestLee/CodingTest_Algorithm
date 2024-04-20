import java.io.*;
import java.util.*;

//2230 수 고르기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int temp;
        while(start <= end && end < n){
            temp = arr[end] - arr[start];
            if(temp >= m){
                start++;
                result = Math.min(result,temp);
            }
            else {
                end++;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}