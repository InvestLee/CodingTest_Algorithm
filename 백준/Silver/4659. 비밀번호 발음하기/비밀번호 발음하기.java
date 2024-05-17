import java.io.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String password;
      char[] pass;
      StringBuilder sb = new StringBuilder();
      boolean flag;
      char prev;
      int count;
      while (!(password = in.readLine()).equals("end")) {
         pass = password.toCharArray();
         prev = '.';
         count = 0;
 
         flag = false;
         for (char p : pass) {
            if (isVowel(p)) flag = true;
 
            if (isVowel(p) != isVowel(prev)) count = 1;
            else count++;
 
            if (count > 2 || (prev == p && (p != 'e' && p != 'o'))) {
               flag = false;
               break;
            }
 
            prev = p;
         }
 
         if (flag) sb.append('<').append(password).append("> is acceptable.\n");
         else sb.append('<').append(password).append("> is not acceptable.\n");
      }
 
      System.out.println(sb);
 
   }
 
   public static boolean isVowel(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
   }
}