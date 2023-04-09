import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Long> dp = new ArrayList<>();
        dp.add(1L);
        dp.add(1L);
        for(int i = 2; i <= n; i++) dp.add(i*dp.get(i-1));
        System.out.println(dp.get(n));
    }
}
