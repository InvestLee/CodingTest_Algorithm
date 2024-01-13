import java.io.*;
import java.util.*;

//2828 사과 담기 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int start = 1;
        int end = m;
        int result = 0;
        int apple;
        for(int i = 0; i < j; i++){
            apple = Integer.parseInt(br.readLine());
            if(start > apple){
                result += start - apple;
                end -= start - apple;
                start = apple;
            }else if(end < apple){
                result += apple - end;
                start += apple - end;
                end = apple;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}