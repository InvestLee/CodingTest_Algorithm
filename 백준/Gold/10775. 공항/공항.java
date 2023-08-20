import java.io.*;
//import java.util.*;

//백준 10775 공항
public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int[] gate = new int[p];
        for(int i = 0; i < p; i++) gate[i] = Integer.parseInt(br.readLine());

        parent = new int[g+1];
        for(int i = 1; i <= g; i++) parent[i] = i;

        int result = 0;
        int possibleGate;
        for(int i = 0; i < p; i++){
            possibleGate = find(gate[i]);

            if(possibleGate == 0) break;

            result++;
            union(possibleGate,possibleGate-1);
        }

        bw.write(result+"");
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
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
