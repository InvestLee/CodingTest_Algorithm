import java.io.*;
import java.util.*;

//18429 근손실
public class Main {
    public static int[] arr;
    public static boolean[] visited;
    public static int n, k, result, weight = 500;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        backtracking(0,weight);
        bw.write(result+"");
        bw.flush();
    }

    public static void backtracking(int cnt, int w){
        if(w < 500) return;
        if(cnt == n){
            result++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(cnt+1, w+arr[i]-k);
                visited[i] = false;
            }
        }
    }
}
