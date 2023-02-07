import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] lcs = new int[a.length()+1][b.length()+1];
        for (int i = 1; i <= a.length(); i++){
            for (int j = 1; j <= b.length(); j++){
                if (a.charAt(i-1) == b.charAt(j-1)) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lcs[a.length()][b.length()]+"\n");

        Stack<Character> st = new Stack<>();
        int lenA = a.length();
        int lenB = b.length();
        while(lenA > 0 && lenB > 0){
            if (lcs[lenA][lenB] == lcs[lenA-1][lenB]) lenA--;
            else if (lcs[lenA][lenB] == lcs[lenA][lenB-1]) lenB--;
            else{
                st.push(a.charAt(lenA-1));
                lenA--;
                lenB--;
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());
        System.out.println(sb);
    }
}