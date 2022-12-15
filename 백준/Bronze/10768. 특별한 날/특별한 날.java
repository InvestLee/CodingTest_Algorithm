import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if (a < 2) System.out.print("Before");
        else if (a > 2) System.out.print("After");
        else if (b < 18) System.out.print("Before");
        else if (b > 18) System.out.print("After");
        else System.out.print("Special");
    }
}