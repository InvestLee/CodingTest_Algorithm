import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_sec = 0;
        for (int i = 0; i < 4; i++){
            int sec = Integer.parseInt(br.readLine());
            total_sec += sec;
        }
        int result_min = total_sec / 60;
        int result_second = total_sec % 60;
        if (result_min < 1){
            System.out.println(1);
            System.out.println(0);
        } else if (result_min >= 60){
            System.out.println(59);
            System.out.println(59);
        } else {
            System.out.println(result_min);
            System.out.println(result_second);
        }
    }
}