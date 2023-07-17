import java.io.*;
import java.util.*;

//백준 10216 Count Circle Groups
public class Main {
    public static int[] parent;
    public static int[][] camp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, result, x_len, y_len, r_len;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            camp = new int[n][3];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    camp[i][j] = Integer.parseInt(st.nextToken());
                }
                parent[i] = i;
            }

            result = n;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    x_len = camp[i][0] - camp[j][0];
                    y_len = camp[i][1] - camp[j][1];
                    r_len = camp[i][2] + camp[j][2];
                    if(x_len * x_len + y_len * y_len <= r_len * r_len){
                        if(find(i) != find(j)){
                            union(i,j);
                            result--;
                        }
                    }
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static int find(int a){
        if(a != parent[a]){
            parent[a] = find(parent[a]);
            return parent[a];
        }
        return a;
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a < b)  parent[b] = a;
        else parent[a] = b;
    }
}
