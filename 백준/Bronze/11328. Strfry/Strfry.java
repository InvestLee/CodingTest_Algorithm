import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer = "Possible";

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            answer = strfry(st.nextToken(), st.nextToken());
            System.out.println(answer);
        }
    }

    public static String strfry(String bfStr, String afStr) {

        if(bfStr.length() != afStr.length()) return "Impossible";

        int bfArr[] = new int[26];
        int afArr[] = new int[26];

        for(int i = 0; i < bfStr.length(); i++) {
            bfArr[bfStr.charAt(i) - 'a']++;
            afArr[afStr.charAt(i) - 'a']++;
        }

        for(int i = 0; i < bfArr.length; i++) {
            if(bfArr[i] != afArr[i]) return "Impossible";
        }

        return "Possible";
    }
}