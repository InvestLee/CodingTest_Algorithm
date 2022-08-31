import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int cnt;
        int temp;
        String result;
        while (true){
            n = sc.nextInt();
            if (n==-1) break;
            result = Integer.toString(n)+" = ";
            cnt = 1;
            temp = 0;
            while (true){
                if (n % cnt == 0){
                    temp += cnt;
                    result += Integer.toString(cnt);
                    if (n <= temp) break;
                    result += " + ";
                }
                cnt += 1;
            }
            if (temp == n && cnt*2==n) System.out.println(result);
            else System.out.println(Integer.toString(n)+" is NOT perfect.");
        }
        sc.close();
    }
}