import java.io.*;
import java.util.*;

//백준 3108 로고
public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] rec = new int[n+1][4];
        parent = new int[n+1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int i = 0; i < 4; i++){
            rec[0][i] = 0;
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                rec[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                if(rec[i][2] < rec[j][0] || rec[i][3] < rec[j][1] || rec[j][2] < rec[i][0] || rec[j][3] < rec[i][1]
                    || (rec[i][0] < rec[j][0] && rec[i][1] < rec[j][1] && rec[i][2] > rec[j][2] && rec[i][3] > rec[j][3])
                    || (rec[i][0] > rec[j][0] && rec[i][1] > rec[j][1] && rec[i][2] < rec[j][2] && rec[i][3] < rec[j][3])){
                    continue;
                }else{
                    if(find(i) != find(j)){
                        union(i,j);
                    }
                }
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i <= n; i++) {
            hashSet.add(find(i));
        }

        bw.write(hashSet.size()-1+"");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
            return parent[a];
        }
        return a;
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}