import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BigInteger n;
        for(int i = 0; i < t; i++){
            n = new BigInteger(br.readLine());
            if(n.isProbablePrime(10)) System.out.println(n);
            else System.out.println(n.nextProbablePrime());
        }
    }
}
