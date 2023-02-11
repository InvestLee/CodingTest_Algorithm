import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static long[] result = new long[3];
    public static long[] liquid;
    public static long minSum = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        liquid = new long[n];
        for (int i = 0; i < n; i++) liquid[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(liquid);
        for (int i = 0; i < n-2; i++) twoPointer(i);
        Arrays.sort(result);
        for (int i = 0; i < 3; i++) System.out.printf("%d ",result[i]);
    }

    public static void twoPointer(int idx){
        int left = idx+1;
        int right = liquid.length-1;
        long currentSum, absSum;
        while (left < right){
            currentSum = liquid[idx]+liquid[left]+liquid[right];
            absSum = Math.abs(currentSum);
            if (absSum < minSum){
                result[0] = liquid[idx];
                result[1] = liquid[left];
                result[2] = liquid[right];
                minSum = absSum;
            }
            if (currentSum > 0) right--;
            else left++;
        }
    }
}