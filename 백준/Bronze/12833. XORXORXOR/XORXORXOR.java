import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int numA = Integer.parseInt(st.nextToken());
        final int numB = Integer.parseInt(st.nextToken());
        final int numC = Integer.parseInt(st.nextToken()) % 2;

        int ans = numA;
        if(numC == 1){
            ans = numA ^ numB;
        }
        System.out.println(ans);
    }
}