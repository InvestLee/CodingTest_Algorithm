import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            if (s.equals("END")) break;
            StringBuilder sb = new StringBuilder(s);
            System.out.println(sb.reverse());
        }
    }
}