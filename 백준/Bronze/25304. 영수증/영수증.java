import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_price = sc.nextInt();
        int num = sc.nextInt();
        int[] price_ea = new int[2];
        int cal_price = 0;
        for (int i = 0; i < num; i++) {
            price_ea[0] = sc.nextInt();
            price_ea[1] = sc.nextInt();
            cal_price += (price_ea[0]*price_ea[1]);
        }
        sc.close();
        if (cal_price == total_price) System.out.print("Yes");
        else System.out.print("No");
    }
}