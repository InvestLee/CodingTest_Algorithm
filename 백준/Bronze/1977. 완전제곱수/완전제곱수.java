import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int min_num = 0;
        for (int i = 1; i < 101; i++){
            if(n < i*i) break;
            if(m <= i*i){
                total += i*i;
                if(min_num == 0) min_num = i*i;
            }
        }
        if (total == 0) System.out.println(-1);
        else{
            System.out.println(total);
            System.out.println(min_num);
        }
    }
}