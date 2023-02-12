import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        long result = 0;
        for (int i = 0; i < n.length(); i++) result = (result*10+(n.charAt(i)-'0')) % 20000303;
        System.out.println(result);
    }
}