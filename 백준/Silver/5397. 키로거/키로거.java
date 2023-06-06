import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> password, waitChar;
        String passwordInput;
        char word;
        while(t-- > 0){
            password = new Stack<>();
            waitChar = new Stack<>();
            passwordInput = br.readLine();
            for(int i = 0; i < passwordInput.length(); i++){
                word = passwordInput.charAt(i);
                if(!password.isEmpty() && word == '-') password.pop();
                else if(!password.isEmpty() && word == '<') waitChar.add(password.pop());
                else if(!waitChar.isEmpty() && word == '>') password.add(waitChar.pop());
                else if(word == '-' || word == '<' || word == '>') continue;
                else password.add(word);
            }
            while(!waitChar.isEmpty()) password.add(waitChar.pop());
            for(int i = 0; i < password.size(); i++) bw.write(password.get(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
