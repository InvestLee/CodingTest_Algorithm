import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i<N; i++) arr[i] = sc.nextInt();
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) System.out.printf("%d ",arr[i]);
        sc.close();
    }
}