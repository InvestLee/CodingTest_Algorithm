import java.io.*;
import java.util.*;

//백준 5533 유니크
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] scores = new int[n][3];

        HashMap<Integer, Integer>[] hashMaps = new HashMap[n];
        for(int i = 0; i < 3; i++){
            hashMaps[i] = new HashMap<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
                hashMaps[j].put(scores[i][j], hashMaps[j].getOrDefault(scores[i][j],0)+1);
            }
        }

        int[] result = new int[n];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < n; j++){
                if(hashMaps[i].get(scores[j][i]) == 1) result[j] += scores[j][i];
            }
        }

        for(int i = 0; i < n; i++){
            bw.write(result[i]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}