import java.io.*;
import java.util.*;

//16204 카드 뽑기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;
        if(m > k){
            result += k+n-m;
        } else {
            result += m+n-k;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
