import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> s_arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) s_arr.add(s.substring(i));
        s_arr.sort(Comparator.naturalOrder());
        for (int i = 0; i < s_arr.size(); i++) System.out.println(s_arr.get(i));
    }
}