import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y - x;
            int max_num = (int)Math.sqrt(distance);
            if (max_num == Math.sqrt(distance)) System.out.println(max_num * 2 - 1);
            else if (distance <= max_num * max_num + max_num) System.out.println(max_num * 2);
            else System.out.println(max_num * 2 + 1);
        }
    }
}