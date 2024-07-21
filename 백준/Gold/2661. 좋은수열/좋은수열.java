import java.io.*;
import java.lang.*;
import java.util.*;
 
 
public class Main {
 
    static int n;
    static String[] list = {"1", "2", "3"};
    static String answer = "9";
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
 
        dfs(0, "");
 
        System.out.println(answer);
    }
 
    private static void dfs(int index, String origin) {
        if (index == n) {
            System.out.println(origin);
            System.exit(0);
        }
 
        for (int i = 0; i <= 2; i++) {
            if (check(origin+list[i])) {
                dfs(index + 1, origin + list[i]);
            }
        }
    }
 
    private static boolean check(String checkStr) {
        int length = checkStr.length() / 2;
 
        for (int i = 1; i <= length; i++) {
            if (checkStr.substring(checkStr.length() - i).equals(checkStr.substring(checkStr.length() - 2 * i, checkStr.length() - i))) {
                return false;
            }
        }
 
        return true;
    }
}