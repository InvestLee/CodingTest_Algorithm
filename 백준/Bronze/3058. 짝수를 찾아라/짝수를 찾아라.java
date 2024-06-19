import java.io.*;
import java.util.*;

//3058 짝수를 찾아라
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int temp, result, min;
        while(t-- > 0){
            result = 0;
            min = 101;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++){
                temp = Integer.parseInt(st.nextToken());
                if(temp % 2 == 0){
                    result += temp;
                    min = Math.min(temp,min);
                }
            }
            bw.write(result+" "+min+"\n");
        }
        bw.flush();
    }
}
