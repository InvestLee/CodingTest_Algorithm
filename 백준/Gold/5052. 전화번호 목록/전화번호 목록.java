import java.io.*;
import java.util.*;

//백준 5052 전화번호 목록
public class Main {

    public static int n;
    public static String[] phoneNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            phoneNumber = new String[n];
            for(int i = 0; i < n; i++){
                phoneNumber[i] = br.readLine();
            }
            Arrays.sort(phoneNumber);

            if(isConsist()) bw.write("YES\n");
            else bw.write("NO\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isConsist(){
        for(int i = 0; i < n - 1; i++){
            if(phoneNumber[i+1].startsWith(phoneNumber[i])){
                return false;
            }
        }
        return true;
    }
}
