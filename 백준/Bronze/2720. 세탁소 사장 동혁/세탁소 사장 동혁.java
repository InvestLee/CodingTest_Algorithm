import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int c, q, d, n;
        while(t-- > 0){
            c = Integer.parseInt(br.readLine());
            q = c / 25;
            c %= 25;
            d = c / 10;
            c %= 10;
            n = c / 5;
            c %= 5;
            System.out.printf("%d %d %d %d\n",q,d,n,c);
        }
    }
}