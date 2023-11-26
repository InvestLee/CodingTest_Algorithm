import java.io.*;
import java.util.*;

//백준 2456 나는 학급회장이다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int temp;
        int[] total = new int[3];
        int[] powTotal = new int[3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                temp = Integer.parseInt(st.nextToken());
                powTotal[j] += Math.pow(temp, 2);
                total[j] += temp;
            }
        }

        int result = 0;
        int maxScore = 0;
        for(int i = 0; i < 3; i++){
            if(powTotal[i] > maxScore){
                result = i+1;
                maxScore = powTotal[i];
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            if(maxScore == powTotal[i]) cnt++;
        }

        if(cnt > 1) bw.write("0 "+total[result-1]);
        else bw.write(result+" "+total[result-1]);
        bw.flush();
        br.close();
        bw.close();
    }
}