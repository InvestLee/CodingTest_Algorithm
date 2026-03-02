import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i = 0; i < a.length(); i++){
            char temp = a.charAt(i);
            if(temp < 91) System.out.print((char)(temp+32));
            else System.out.print((char)(temp-32));
        }
    }
}