import java.io.*;
import java.util.*;

//백준 2012 등수 매기기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        long result = 0;
        for(int i = 0; i < n; i++) result += Math.abs(arr[i] - (i+1));

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}