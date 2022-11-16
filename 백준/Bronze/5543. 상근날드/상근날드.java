import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minimum_burger = 2000;
        for (int i = 0; i < 3; i++){
            int burger = Integer.parseInt(br.readLine());
            if (minimum_burger > burger) minimum_burger = burger;
        }
        int minimum_drink = 2000;
        for (int i = 0; i < 2; i++){
            int drink = Integer.parseInt(br.readLine());
            if (minimum_drink > drink) minimum_drink = drink;
        }
        br.close();
        System.out.println(minimum_burger+minimum_drink-50);
    }
}