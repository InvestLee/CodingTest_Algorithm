import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bowl = sc.next();
        String[] bowl_arr = bowl.split("");
        int result = 10;
        for (int i = 1; i < bowl_arr.length; i++){
            if (!bowl_arr[i].equals(bowl_arr[i-1])) result += 10;
            else result += 5;
        }
        System.out.println(result);
        sc.close();
    }
}