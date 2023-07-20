import java.io.*;
import java.util.*;

//백준 2343 기타 레슨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lecture = new int[n];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            lecture[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start,lecture[i]);
            end += lecture[i];
        }

        int mid, sum, count;
        while(start <= end){
            mid = (start+end) / 2;
            sum = 0;
            count = 0;
            for(int i = 0; i < n; i++){
                if(sum+lecture[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += lecture[i];
            }
            if(sum != 0) count++;
            if(count > m) start = mid + 1;
            else end = mid - 1;
        }

        bw.write(start+"");
        bw.flush();
        bw.close();
    }
}
