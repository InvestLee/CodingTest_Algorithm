import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, result, kill;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dragon = new int[n];
        for (int i = 0; i < n; i++) dragon[i] = Integer.parseInt(st.nextToken());

        result = 0;
        for (int i = 0; i < n; i++){
            kill = 0;
            for (int j = i+1; j < n; j++){
                if(dragon[i] < dragon[j]) break;
                kill++;
            }
            result = Math.max(result, kill);
        }
        System.out.println(result);
    }
}
