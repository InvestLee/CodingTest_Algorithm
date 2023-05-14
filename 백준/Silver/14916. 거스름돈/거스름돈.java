import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result, remain;
        int count = n/5;
        while(true){
            result = 0;
            remain = n - 5*count;
            result += count;
            result += remain / 2;
            if(count < 0){
                result = -1;
                break;
            }
            if(remain % 2 == 0) break;
            count--;
        }
        System.out.println(result);
    }
}
