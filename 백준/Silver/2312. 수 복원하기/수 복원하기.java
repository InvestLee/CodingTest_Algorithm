import java.io.*;

//2312 수 복원하기
public class Main {public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int n, cnt;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            for(int i = 2; i <= n; i++){
                cnt = 0;
                while(n % i == 0) {
                    n /= i;
                    cnt++;
                }
                if(cnt != 0) bw.write(i+" "+cnt+"\n");
                if(n==0) break;
            }
        }
        bw.flush();
    }
}