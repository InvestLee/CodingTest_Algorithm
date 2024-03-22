import java.io.*;
import java.util.*;

//11497 통나무 건너뛰기
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n, left, right, result;
        StringTokenizer st;
        PriorityQueue<Integer> pq;
        int[] arr;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>((o1,o2) -> o2- o1);
            arr = new int[n];
            for(int i = 0; i < n; i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
            arr[n/2] = pq.poll();
            left = n/2 - 1;
            right = n/2 + 1;
            while(!pq.isEmpty()){
                if(right < n) arr[right++] = pq.poll();
                if(!pq.isEmpty()) arr[left--] = pq.poll();
            }
            result = Math.abs(arr[0]-arr[n-1]);
            for(int i = 1; i < n; i++){
                result = Math.max(result, Math.abs(arr[i]-arr[i-1]));
            }
            bw.write(result+"\n");
        }

        bw.flush();
    }
}
