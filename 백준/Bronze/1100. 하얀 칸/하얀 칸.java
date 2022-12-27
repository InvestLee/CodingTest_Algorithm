import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 0; i < 8; i++){
            String area_line = br.readLine();
            for (int j = 0; j < 8; j++){
                if ((i+j) % 2 == 0 && area_line.charAt(j) == 'F') result++;
            }
        }
        System.out.println(result);
    }
}