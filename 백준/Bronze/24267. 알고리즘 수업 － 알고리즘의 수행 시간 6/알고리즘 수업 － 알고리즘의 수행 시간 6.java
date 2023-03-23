import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());

        System.out.println(n.multiply(n.subtract(new BigInteger("1")).multiply(n.subtract(new BigInteger("2")))).divide(new BigInteger("6")));

        System.out.println(3);

    }

}