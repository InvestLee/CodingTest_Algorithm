import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dot = 2;
        for(int i = 0; i < n; i++){
            dot += Math.pow(2,i);
        }
        System.out.println(dot*dot);
    }
}
