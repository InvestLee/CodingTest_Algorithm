import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {0,0,0,0,0};
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            if (x == 0 || y == 0) arr[0] += 1;
            else if (x > 0 && y > 0) arr[1] += 1;
            else if (x < 0 && y > 0) arr[2] += 1;
            else if (x < 0 && y < 0) arr[3] += 1;
            else if (x > 0 && y < 0) arr[4] += 1;
        }
        sc.close();
        System.out.printf("Q1: %d\n",arr[1]);
        System.out.printf("Q2: %d\n",arr[2]);
        System.out.printf("Q3: %d\n",arr[3]);
        System.out.printf("Q4: %d\n",arr[4]);
        System.out.printf("AXIS: %d",arr[0]);
    }
}