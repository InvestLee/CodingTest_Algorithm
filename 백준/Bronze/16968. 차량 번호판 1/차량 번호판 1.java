import java.io.*;

//16968 차량 번호판 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int result;
        if(str.charAt(0) == 'd') result = 10;
        else result = 26;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                if(str.charAt(i) == 'd') result *= 9;
                else result *= 25;
            } else {
                if(str.charAt(i) == 'd') result *= 10;
                else result *= 26;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}