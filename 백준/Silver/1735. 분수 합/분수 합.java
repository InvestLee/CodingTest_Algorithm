import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long as = Long.parseLong(st.nextToken());
        long am = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long bs = Long.parseLong(st.nextToken());
        long bm = Long.parseLong(st.nextToken());

        long s = as*bm+bs*am;
        long m = am*bm;

        long big, small, temp;
        if (s>m){
            big = s;
            small = m;
        } else {
            big = m;
            small = s;
        }

        while(true){
            temp = small;
            small = big%small;
            big = temp;
            if(small == 0){
                System.out.printf("%d %d",s/big,m/big);
                break;
            }
        }
    }
}