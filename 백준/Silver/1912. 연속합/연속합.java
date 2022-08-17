import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            num[i] = Math.max(num[i],num[i]+num[i-1]);
        }
        sc.close();
        System.out.print(Arrays.stream(num).max().getAsInt());
    }
}