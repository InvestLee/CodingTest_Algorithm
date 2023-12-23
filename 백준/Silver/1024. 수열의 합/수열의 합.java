import java.io.*;
import java.util.*;

//1024 수열의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int temp, start;
        boolean flag = false;
        for(int i = l; i <= 100; i++){
            temp = n - i * (i + 1) / 2;
            if(temp % i == 0){
                start = temp / i + 1;
                if(start >= 0){
                    flag = true;
                    for(int j = 0; j < i; j++){
                        bw.write(start + j + " ");
                    }
                    break;
                }
            }
        }

        if(!flag) bw.write(-1+"");
        bw.flush();
        bw.close();
        br.close();
    }
}