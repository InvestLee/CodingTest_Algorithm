import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String[] p_arr = p.split("");
        List<String> p_list = new ArrayList<>(Arrays.asList(p_arr));
        Collections.reverse(p_list);
        String[] p_arr2 = p_list.toArray(new String[p_list.size()]);
        sc.close();
        if (Arrays.equals(p_arr, p_arr2)) System.out.println(1);
        else System.out.println(0);
    }
}