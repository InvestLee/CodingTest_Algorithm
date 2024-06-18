import java.io.*;
import java.util.*;

//27110 특식 배부
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int result = 0;
        int temp;
        for(int i = 0; i < 3; i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp < n) result += temp;
            else result += n;
        }
        bw.write(result+"");
        bw.flush();
    }
}