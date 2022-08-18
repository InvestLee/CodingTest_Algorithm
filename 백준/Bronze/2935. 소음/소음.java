import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger A = sc.nextBigInteger();
        String C = sc.next();
        BigInteger B = sc.nextBigInteger();
        if (C.equals("*")) System.out.println(A.multiply(B));
        else System.out.println(A.add(B));
        sc.close();
    }
}