import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.countTokens() > 0){
                StringBuilder sb = new StringBuilder(st.nextToken());
                System.out.print(sb.reverse()+" ");
            }
            System.out.println();
        }
    }
}