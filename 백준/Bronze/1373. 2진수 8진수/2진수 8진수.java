import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        if(num.length() % 3 == 1) {
            sb.append(num.charAt(0)-'0');
        }
        if(num.length() % 3 == 2) {
            sb.append((num.charAt(0) - '0')*2+(num.charAt(1) - '0'));
        }
        for (int i = num.length() % 3; i < num.length(); i+=3){
            sb.append((num.charAt(i) - '0')*4+(num.charAt(i+1) - '0')*2+(num.charAt(i+2) - '0'));
        }
        System.out.println(sb);
    }
}