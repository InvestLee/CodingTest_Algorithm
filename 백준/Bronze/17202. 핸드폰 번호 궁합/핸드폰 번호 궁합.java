import java.io.*;

//17202 핸드폰 번호 궁합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        String result = "";

        for(int i = 0; i < 8; i++){
            result += a.charAt(i);
            result += b.charAt(i);
        }

        String temp;
        int num;
        while(result.length() > 2){
            temp = "";
            for(int i = 0; i < result.length()-1; i++){
                num = (result.charAt(i) - '0') + (result.charAt(i+1) - '0');
                temp += Integer.toString(num % 10);
            }
            result = temp;
        }
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}