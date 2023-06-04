import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n, result, nextNum;
        int[] arr;
        boolean[] visited;
        StringTokenizer st;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            result = 0;

            for(int i = 1; i < n+1; i++) arr[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i < n+1; i++){
                if(visited[i]) continue;
                nextNum = i;
                while(true){
                    visited[nextNum] = true;
                    nextNum = arr[nextNum];
                    if(visited[nextNum]){
                        result++;
                        break;
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
