import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] score = new int[8][2];
        for (int i = 0; i < 8; i++) {
            score[i][0] = Integer.parseInt(br.readLine());
            score[i][1] = i+1;
        }

        Arrays.sort(score, (o1, o2) -> o2[0]-o1[0]);

        int result = 0;
        int[] problemNum = new int[5];
        for (int i = 0; i < 5; i++) {
            result += score[i][0];
            problemNum[i] = score[i][1];
        }
        Arrays.sort(problemNum);

        System.out.println(result);
        for (int i = 0; i < 5; i++) System.out.printf("%d ",problemNum[i]);
    }
}