import java.io.*;
import java.util.*;

//1059 좋은 구간
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(arr[i] > m) right = Math.min(right, arr[i]);
            else if(arr[i] < m) left = Math.max(left,arr[i]);
            else{
                flag = true;
                break;
            }
        }
        int leftValue = (m-left-1);
        int rightValue = (right-m-1);
        int result = leftValue + rightValue + (leftValue * rightValue);
        if(flag) bw.write("0");
        else bw.write(result+"");

        bw.flush();
        bw.close();
    }
}