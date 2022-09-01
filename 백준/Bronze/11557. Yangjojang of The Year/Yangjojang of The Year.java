import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n;
        String input_university;
        int input_alcohol;
        String result_university = "";
        int result_alcohol = 0;
        for (int i = 0; i<T; i++){
            n = sc.nextInt();
            for (int j = 0; j < n; j++){
                input_university = sc.next();
                input_alcohol = sc.nextInt();
                if (input_alcohol > result_alcohol){
                    result_university = input_university;
                    result_alcohol = input_alcohol;
                }
            }
            System.out.println(result_university);
            result_university = "";
            result_alcohol = 0;
        }
        sc.close();
    }
}