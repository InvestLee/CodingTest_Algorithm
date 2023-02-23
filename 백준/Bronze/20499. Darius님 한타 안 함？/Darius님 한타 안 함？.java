import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kda = br.readLine().split("/");
        int ka = Integer.parseInt(kda[0])+Integer.parseInt(kda[2]);
        int d = Integer.parseInt(kda[1]);
        if (d == 0 || ka < d) System.out.println("hasu");
        else System.out.println("gosu");
    }
}