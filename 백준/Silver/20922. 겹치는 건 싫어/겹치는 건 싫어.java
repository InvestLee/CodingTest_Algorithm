import java.io.*;
import java.util.*;

//20922 겹치는 건 싫어
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];

        int result = 0;
        int start = 0, end = 0;
        while(end < n){
            while(end < n && cnt[arr[end]] + 1 <= k){
                cnt[arr[end]]++;
                end++;
            }
            result = Math.max(result, end-start);
            cnt[arr[start]]--;
            start++;
        }

        bw.write(result+"");
        bw.flush();
    }
}