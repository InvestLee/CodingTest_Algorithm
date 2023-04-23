import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int result, n, m;
        String num;
        while (t-- > 0){
            result = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for(int i = n; i  <= m; i++){
                num = String.valueOf(i);
                for(int j = 0; j  < num.length();  j++){
                    if(num.charAt(j) == '0') result++;
                }
            }
            System.out.println(result);
        }
    }
}
