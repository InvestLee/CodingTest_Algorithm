import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static ArrayList<Integer> triangleList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpha = "0"+br.readLine();
        long[] dp = new long[alpha.length()];
        if (alpha.charAt(1)=='0') System.out.println(0);
        else {
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < alpha.length(); i++){
                if (alpha.charAt(i) > '0') dp[i] += dp[i-1] % 1000000;
                String twoChar = alpha.substring(i-1,i+1);
                if (Integer.parseInt(twoChar) >= 10 && Integer.parseInt(twoChar) <= 26) dp[i] += dp[i-2] % 1000000;
            }
            System.out.println(dp[alpha.length()-1]%1000000);
        }
    }
}