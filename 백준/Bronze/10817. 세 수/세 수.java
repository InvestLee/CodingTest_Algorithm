import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
        Arrays.sort(arr);
        System.out.println(arr[1]);
        sc.close();
    }
}