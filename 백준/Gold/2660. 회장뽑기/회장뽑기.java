import java.io.*;
import java.util.*;

//2660 회장뽑기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];

        StringTokenizer st;
        int a, b;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                        if(i == j) continue;
                        if(arr[i][k] == 0 || arr[k][j] == 0) continue;
                        if(arr[i][j] == 0 || arr[i][j] > arr[i][k] + arr[k][j]){
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                }
            }
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int score;
        List<Integer> temp;
        for(int i = 1; i <= n; i++){
            score = 0;
            for(int j = 1; j <= n; j++){
                score = Math.max(score, arr[i][j]);
            }
            temp = new ArrayList<>();
            if(map.containsKey(score)) temp = map.get(score);
            temp.add(i);
            map.put(score,temp);
        }

        bw.write(map.firstKey()+" ");
        bw.write(map.get(map.firstKey()).size()+"\n");
        for(Integer i : map.get(map.firstKey())){
            bw.write(i+" ");
        }
        bw.flush();
    }
}