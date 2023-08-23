import java.io.*;
import java.util.*;

//백준 1647 도시 분할 계획
public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cityRoad = new int[m][3];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                cityRoad[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(cityRoad, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        parent = new int[n+1];
        for(int i = 1; i <= n; i++) parent[i] = i;

        int result = 0;
        int largestCost = 0;
        for(int i = 0; i < m; i++){
            if(find(cityRoad[i][0]) != find(cityRoad[i][1])){
                result += cityRoad[i][2];
                union(cityRoad[i][0], cityRoad[i][1]);
                largestCost = cityRoad[i][2];
            }
        }

        bw.write(result-largestCost+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}