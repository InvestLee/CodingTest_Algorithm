import java.io.*;
import java.util.*;

//백준 1027 고층 건물
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n];
        int[] visible = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        double lean, nextLean;
        for(int i = 0; i < n-1; i++){
            visible[i]++;
            visible[i+1]++;
            lean = building[i+1] - building[i];
            for(int j = i+2; j < n; j++){
                nextLean = (double)(building[j] - building[i]) / (j-i);
                if(nextLean <= lean) continue;
                lean = nextLean;
                visible[i]++;
                visible[j]++;
            }
        }

        Arrays.sort(visible);
        bw.write(visible[n-1]+"");
        bw.flush();
        bw.close();
    }
}
