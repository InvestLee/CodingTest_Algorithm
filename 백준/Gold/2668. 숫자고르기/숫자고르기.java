import java.io.*;
import java.util.*;

//2668 숫자고르기
public class Main {

    public static ArrayList<Integer> result;
    public static boolean[] visited;
    public static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) num[i] = Integer.parseInt(br.readLine());

        result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        result.sort(Comparator.naturalOrder());
        bw.write(result.size()+"\n");
        for(int i = 0; i < result.size(); i++) bw.write(result.get(i)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int target){
        if(visited[num[start]] == false){
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        if(num[start] == target) result.add(target);
    }
}