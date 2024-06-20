import java.io.*;
import java.util.*;

//9076 점수 집계
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            arr = new int[5];
            for(int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if(arr[3]-arr[1] >= 4) bw.write("KIN\n");
            else bw.write(arr[1]+arr[2]+arr[3]+"\n");
        }
        bw.flush();
    }
}