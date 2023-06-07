import java.io.*;
import java.util.*;

public class Main {

    public static int n, result, temp;
    public static int[] arr;
    public static Stack<Integer> permutationArr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        permutationArr = new Stack<>();
        visited = new boolean[n];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dfs();
        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(){
        if(permutationArr.size() == n){
            temp = 0;
            for(int i = 1; i < n; i++) temp += Math.abs(permutationArr.get(i)-permutationArr.get(i-1));
            result = Math.max(result,temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                permutationArr.add(arr[i]);
                dfs();
                visited[i] = false;
                permutationArr.pop();
            }
        }
    }
}
