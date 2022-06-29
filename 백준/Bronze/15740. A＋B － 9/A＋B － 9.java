import java.util.Scanner;
import java.math.BigInteger; //아주아주 큰 수 출력을 위한 라이브러리

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();
        sc.close();
        System.out.println(A.add(B)); // 사칙연산이 아닌 메소드를 사용해야 함
    }
}
