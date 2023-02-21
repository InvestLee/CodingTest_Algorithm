import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int smallStr, bigStr, num, blank;
        char c;
        String str;
        while((str = br.readLine()) != null){
            smallStr = 0;
            bigStr = 0;
            num = 0;
            blank = 0;
            for (int i = 0; i < str.length(); i++){
                c = str.charAt(i);
                if(c >= 'a' && c <= 'z') smallStr++;
                else if(c >= 'A' && c <= 'Z') bigStr++;
                else if(c >= '0' && c <= '9') num++;
                else blank++;
            }
            System.out.printf("%d %d %d %d\n", smallStr, bigStr, num, blank);
        }
    }
}