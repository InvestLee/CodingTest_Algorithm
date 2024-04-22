import java.io.*;
import java.util.*;

//1041 주사위
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1Value = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            s1Value = Math.min(arr[i], s1Value);
        }

        long result;
        if(n == 1){
            Arrays.sort(arr);
            result = 0;
            for(int i = 0; i < 5; i++) result += arr[i];
            bw.write(result+"");
        } else {
            long s3 = 4;
            long s2 = 4L * (n-1) + 4L * (n-2);
            long s1 = (long) n * n * 5 - (s3 * 3 + s2 * 2);
            int s3Value = Math.min(arr[0], arr[5]) + Math.min(arr[1], arr[4]) + Math.min(arr[2], arr[3]);
            int s2Value = Integer.MAX_VALUE;
            for(int i = 0; i < 6; i++){
                for(int j = i + 1; j < 6; j++){
                    if(i+j != 5) s2Value = Math.min(s2Value, arr[i] + arr[j]);
                }
            }
            result = s1 * s1Value + s2 * s2Value + s3 * s3Value;
            bw.write(result+"");
        }
        bw.flush();
    }
}