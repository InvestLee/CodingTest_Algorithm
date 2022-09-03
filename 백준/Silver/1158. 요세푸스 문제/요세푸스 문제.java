import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) q.add(i);
        System.out.print("<");
        while (q.size()>0){
            for (int i = 1; i < K; i++) q.add(q.poll());
            if (q.size()>1) System.out.printf("%d, ",q.poll());
            else System.out.printf("%d",q.poll());
        }
        System.out.print(">");
        sc.close();
    }
}