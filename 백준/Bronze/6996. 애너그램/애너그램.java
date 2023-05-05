import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String s1, s2;
        String[] arr1, arr2;
        while (n-- > 0){
            st = new StringTokenizer(br.readLine());
            s1 = st.nextToken();
            arr1 = s1.split("");
            Arrays.sort(arr1);
            s2 = st.nextToken();
            arr2 = s2.split("");
            Arrays.sort(arr2);
            if (Arrays.equals(arr1,arr2)) System.out.println(s1+ " & " +s2+ " are anagrams.");
            else System.out.println(s1+ " & " +s2+ " are NOT anagrams.");
        }
    }
}