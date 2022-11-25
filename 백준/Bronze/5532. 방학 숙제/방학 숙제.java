import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        double c = Double.parseDouble(br.readLine());
        double d = Double.parseDouble(br.readLine());
        int lang_day = (int) Math.ceil(a/c);
        int math_day = (int) Math.ceil(b/d);
        if (lang_day > math_day) System.out.println(l-lang_day);
        else System.out.println(l-math_day);
    }
}