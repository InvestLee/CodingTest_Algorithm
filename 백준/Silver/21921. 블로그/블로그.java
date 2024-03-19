import java.io.*;
import java.util.*;

//21921 블로그
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < x; i++){
            sum += arr[i];
        }

        int max = sum;
        int maxCnt = 1;
        for(int i = x; i < n; i++){
            sum += arr[i] - arr[i-x];
            if(max == sum) maxCnt++;
            else if(max < sum){
                max = sum;
                maxCnt = 1;
            }
        }

        if(max == 0){
            bw.write("SAD"+"\n");
        } else {
            bw.write(max+"\n");
            bw.write(maxCnt+"\n");
        }

        bw.flush();
    }
}
