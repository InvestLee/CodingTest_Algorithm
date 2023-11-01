import java.io.*;
import java.util.*;

//백준 2953 나는 요리사다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int total;
        int result = 0;
        int num = 0;
        for(int i = 1; i <= 5; i++){
            total = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) total += Integer.parseInt(st.nextToken());
            if(result < total){
                num = i;
                result = total;
            }
        }

        bw.write(num+" "+result);
        bw.flush();
        br.close();
        bw.close();
    }
}