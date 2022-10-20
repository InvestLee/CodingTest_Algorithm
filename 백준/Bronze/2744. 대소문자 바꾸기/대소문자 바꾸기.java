import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        br.close();
        for (int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);
            if (65 <= temp && temp <= 90) System.out.print((char)(temp+32));
            else if (97 <= temp && temp <= 122) System.out.print((char)(temp-32));
        }
    }
}