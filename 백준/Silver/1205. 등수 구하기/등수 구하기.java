import java.io.*;
import java.util.*;

//1205 등수 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Integer[] score = new Integer[p];
        for (int i = 0; i < p; i++) score[i] = 0;
        if(n > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) score[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(score, Collections.reverseOrder());
        int result;
        if(n == p && score[p-1] >= newScore){
            result = -1;
        } else {
            result = 1;
            for(int i = 0; i < p; i++){
                if(score[i] > newScore) result++;
                else break;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}