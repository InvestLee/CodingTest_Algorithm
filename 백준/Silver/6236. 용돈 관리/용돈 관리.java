import java.io.*;
import java.util.*;

//6236 용돈 관리
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] need = new int[n];
        int min = 0, max = 0;
        for(int i = 0; i < n; i++){
            need[i] = Integer.parseInt(br.readLine());
            min = Math.max(min,need[i]);
            max += need[i];
        }

        int mid, cnt, sum;
        while(min <= max){
            mid = (min+max)/2;
            sum = 0;
            cnt = 1;

            for(int i = 0; i < n; i++){
                sum += need[i];
                if(sum > mid){
                    sum = need[i];
                    cnt++;
                }
            }
            if(cnt > m) min = mid + 1;
            else max = mid - 1;
        }
        bw.write(min+"");
        bw.flush();
    }
}