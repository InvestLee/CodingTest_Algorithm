import java.io.*;
import java.util.StringTokenizer;

//15953 상금 헌터
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a, b, result;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            result = 0;

            if(a == 1) result += 500;
            else if(a == 2 || a == 3) result += 300;
            else if(4 <= a && a <= 6) result += 200;
            else if(7 <= a && a <= 10) result += 50;
            else if(11 <= a && a <= 15) result += 30;
            else if(16 <= a && a <= 21) result += 10;

            if(b == 1) result += 512;
            else if(b == 2 || b == 3) result += 256;
            else if(4 <= b && b <= 7) result += 128;
            else if(8 <= b && b <= 15) result += 64;
            else if(16 <= b && b <= 31) result += 32;

            bw.write(result*10000+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}