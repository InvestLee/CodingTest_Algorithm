import java.io.*;
import java.util.*;

//2170 선 긋기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, Comparator.comparingInt(o -> o[0]));

        int start = line[0][0];
        int end = line[0][1];
        int result = 0;

        for(int i = 1; i < n; i++){
            if(end < line[i][0]){
                result += (end - start);
                start = line[i][0];
                end = line[i][1];
            } else if(end < line[i][1]){
                end = line[i][1];
            }
        }
        result += (end-start);

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}