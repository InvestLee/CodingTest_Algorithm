import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        String ss = sc.next();
        String[] arr = ss.split("");
        int A_count =(int) Arrays.stream(arr).filter(s->s.contains("A")).count();
        int B_count =(int) Arrays.stream(arr).filter(s->s.contains("B")).count();
        if (A_count > B_count) System.out.println("A");
        else if (A_count < B_count) System.out.println("B");
        else System.out.println("Tie");
        sc.close();
    }
}