import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i=0; i<T; i++){
            String SS = sc.nextLine();
            String[] S_list = SS.split(" ");
            double num = Double.parseDouble(S_list[0]);
            for (int j=1; j< S_list.length;j++){
                if (S_list[j].equals("@")) num *= 3;
                else if (S_list[j].equals("%")) num += 5;
                else if (S_list[j].equals("#")) num -= 7;
            }
            System.out.printf("%.2f\n",num);
        }
        sc.close();
    }
}