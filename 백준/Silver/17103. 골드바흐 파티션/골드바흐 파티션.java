import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int j, n, result;

        boolean[] primeNum = new boolean[1000001];
        primeNum[0] = primeNum[1] = true;
        for(int i = 2; i * i < 1000001; i++){
            j = 2;
            while(i*j < 1000001){
                primeNum[i*j] = true;
                j++;
            }
        }

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            result = 0;
            for (int i = 2; i <= n / 2; i++){
                if(!primeNum[i] && !primeNum[n-i]) result++;
            }
            System.out.println(result);
        }
    }
}
