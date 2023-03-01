import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int cnt = 0;
        while(n > 0){
            int power = (int) Math.pow(10,cnt);
            if (n >= 9 * power){
                result += 9 * power * (cnt+1);
                n -= 9 * power;
                cnt++;
            } else {
                result += n * (cnt+1);
                break;
            }
        }
        System.out.println(result);
    }
}