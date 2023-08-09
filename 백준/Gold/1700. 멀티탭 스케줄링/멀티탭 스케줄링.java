import java.io.*;
import java.util.*;

//백준 1700 멀티탭 스케줄링
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tool = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) tool[i] = Integer.parseInt(st.nextToken());
        boolean[] used = new boolean[k+1];
        int[] visited;

        int result = 0;
        int using = 0;
        int unplug;
        for(int i = 0; i < k; i++){
            if(used[tool[i]]) continue;
            if(using < n){
                used[tool[i]] = true;
                using++;
            } else {
                visited = new int[k+1];
                for(int j = 1; j <= k; j++){
                    if(used[j]){
                        visited[j] = Integer.MAX_VALUE;
                    }
                }
                for(int j = i+1; j < k; j++){
                    if(visited[tool[j]] == Integer.MAX_VALUE){
                        visited[tool[j]] = j;
                    }
                }
                unplug = 0;
                for(int j = 1; j <= k; j++){
                    if(visited[j] > visited[unplug]){
                        unplug = j;
                    }
                }
                used[unplug] = false;
                result++;
                used[tool[i]] = true;
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
