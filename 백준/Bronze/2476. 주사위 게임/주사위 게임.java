import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max_result = 0;
        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == b && b == c) max_result = Math.max(max_result,10000+a*1000);
            else if (a==b || a==c) max_result = Math.max(max_result,1000+a*100);
            else if (b==c) max_result = Math.max(max_result,1000+b*100);
            else max_result = Math.max(max_result,Math.max(a,Math.max(b,c))*100);
        }
        sc.close();
        System.out.println(max_result);
    }
}