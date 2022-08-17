import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        String[] s_arr = s.split("");
        int count_one = 0;
        int count_zero = 0;
        if (s_arr[0].equals("0")) count_zero++;
        else count_one++;
        for (int i = 1; i < s_arr.length; i++) {
            if (s_arr[i].equals("0") && s_arr[i-1].equals("1")) count_zero++;
            else if (s_arr[i].equals("1") && s_arr[i-1].equals("0")) count_one++;
        }
        System.out.println(Math.min(count_one,count_zero));
    }
}