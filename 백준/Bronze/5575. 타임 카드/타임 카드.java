import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] workingTime = new int[6];
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) workingTime[j] = Integer.parseInt(st.nextToken());
            int startTime = workingTime[0] * 3600 + workingTime[1] * 60 + workingTime[2];
            int endTime = workingTime[3] * 3600 + workingTime[4] * 60 + workingTime[5];
            int resultSecond = endTime - startTime;
            int[] result = new int[2];
            result[0] = resultSecond / 3600;
            resultSecond %= 3600;
            result[1] = resultSecond / 60;
            resultSecond %= 60;
            System.out.printf("%d %d %d\n",result[0],result[1],resultSecond);
        }
    }
}