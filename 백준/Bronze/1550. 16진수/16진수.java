import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        sc.close();
        int dec = Integer.parseInt(hex,16); //16진수를 10진수로
        System.out.println(dec);
    }
}