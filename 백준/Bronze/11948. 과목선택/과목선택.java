import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int min1 = 101;
        int min2 = 101;
        for (int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(br.readLine());
            result += temp;
            if (min1 > temp) min1 = temp;
        }
        for (int i = 0; i < 2; i++) {
            int temp = Integer.parseInt(br.readLine());
            result += temp;
            if (min2 > temp) min2 = temp;
        }
        System.out.println(result-min1-min2);
    }
}