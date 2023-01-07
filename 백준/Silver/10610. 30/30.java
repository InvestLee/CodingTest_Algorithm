import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        Arrays.sort(n, Comparator.reverseOrder());
        int sumTotal = 0;
        for (int i = 0; i < n.length; i++) sumTotal += Integer.parseInt(n[i]);
        if (!n[n.length-1].equals("0") || sumTotal % 3 != 0) System.out.print(-1);
        else for (int i = 0; i < n.length; i++) System.out.print(n[i]);
    }
}