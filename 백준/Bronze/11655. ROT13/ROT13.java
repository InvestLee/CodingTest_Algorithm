import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ' || (int)c < 58) System.out.print(c);
            else if ((int)c < 91 && (int)c > 77) System.out.print((char)(c+13-91+65));
            else if ((int)c < 123 && (int)c > 109) System.out.print((char)(c+13-123+97));
            else System.out.print((char)(c+13));
        }
    }
}