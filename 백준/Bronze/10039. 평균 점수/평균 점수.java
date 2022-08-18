import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int temp = 0;
        for (int i=0; i<5; i++){
            temp = sc.nextInt();
            if (temp < 40) arr[i] = 40;
            else arr[i] = temp;
        }
        System.out.println(Arrays.stream(arr).sum()/5);
        sc.close();
    }
}