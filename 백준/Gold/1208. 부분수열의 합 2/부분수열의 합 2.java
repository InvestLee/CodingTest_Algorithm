import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n;
    public static int s;
    public static int[] arr;
    public static ArrayList<Integer> leftAllSum, rightAllSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        leftAllSum = new ArrayList<>();
        rightAllSum = new ArrayList<>();
        devideAllSum(0,n/2,0,leftAllSum);
        devideAllSum(n/2,n,0,rightAllSum);
        leftAllSum.sort(Comparator.naturalOrder());
        rightAllSum.sort(Comparator.naturalOrder());

        long result = 0;
        int left = 0;
        int right = rightAllSum.size()-1;
        while(left < leftAllSum.size() && right >= 0){
            int leftValue = leftAllSum.get(left);
            int rightValue = rightAllSum.get(right);
            if(leftValue + rightValue == s){
                long leftCount = 0;
                long rightCount = 0;
                while(left < leftAllSum.size() && leftValue == leftAllSum.get(left)){
                    leftCount++;
                    left++;
                }
                while(right >= 0 && rightValue == rightAllSum.get(right)){
                    rightCount++;
                    right--;
                }
                result += leftCount*rightCount;
            }
            if(leftValue + rightValue < s) left++;
            if(leftValue + rightValue > s) right--;
        }
        if (s == 0) result--;
        System.out.println(result);
    }

    public static void devideAllSum(int idx, int end, int total, ArrayList<Integer> al){
        if(idx == end){
            al.add(total);
            return;
        }
        devideAllSum(idx+1,end,total+arr[idx],al);
        devideAllSum(idx+1,end,total,al);
    }
}