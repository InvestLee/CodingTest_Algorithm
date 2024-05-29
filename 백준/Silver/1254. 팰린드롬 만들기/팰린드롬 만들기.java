import java.io.*;

//1254 팰린드롬 만들기
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int result = s.length();
        for(int i = 0; i < s.length(); i++){
            if(isPal(s.substring(i))) break;
            result++;
        }
        bw.write(result+"");
        bw.flush();
    }

    public static boolean isPal(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}