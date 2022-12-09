import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remain_money = 1000-Integer.parseInt(br.readLine());
        int result = 0;
        result += remain_money / 500;
        remain_money %= 500;
        result += remain_money / 100;
        remain_money %= 100;
        result += remain_money / 50;
        remain_money %= 50;
        result += remain_money / 10;
        remain_money %= 10;
        result += remain_money / 5;
        remain_money %= 5;
        result += remain_money / 1;
        System.out.println(result);
    }
}