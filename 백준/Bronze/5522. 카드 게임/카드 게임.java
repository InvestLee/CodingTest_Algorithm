import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());
        BigInteger d = new BigInteger(br.readLine());
        BigInteger e = new BigInteger(br.readLine());
        br.close();
        System.out.println(a.add(b.add(c.add(d.add(e)))));
    }
}