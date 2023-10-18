import java.io.*;
import java.util.*;

//백준 2455 지능형 기차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int result = 0;

        int getOff, getOn;
        int temp = result;
        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            getOff = Integer.parseInt(st.nextToken());
            getOn = Integer.parseInt(st.nextToken());
            temp -= getOff;
            temp += getOn;
            if(temp > 10000) temp = 10000;
            result = Math.max(temp, result);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}