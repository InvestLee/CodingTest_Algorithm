import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int total = s+k+h;
        if (total >= 100) System.out.println("OK");
        else if (s < k && s < h) System.out.println("Soongsil");
        else if (k < s && k < h) System.out.println("Korea");
        else System.out.println("Hanyang");
    }
}