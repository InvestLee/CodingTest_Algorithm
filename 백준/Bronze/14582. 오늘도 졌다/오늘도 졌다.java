import java.io.*;
import java.util.*;

//14582 오늘도 졌다
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        String result = "No";
        int score = 0;
        for (int i = 0; i < 9; i++) {
            score += Integer.parseInt(st1.nextToken());
            if (score > 0) {
                result = "Yes";
                break;
            }
            score -= Integer.parseInt(st2.nextToken());
        }

        bw.write(result+"");
        bw.flush();
    }
}