import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] room = new int[2][6];
        int sex, grade;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            sex = Integer.parseInt(st.nextToken());
            grade = Integer.parseInt(st.nextToken());
            room[sex][grade-1]++;
        }

        int result = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++){
                if(room[i][j] == 0) continue;
                if(room[i][j] % k != 0) result++;
                result += room[i][j] / k;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
