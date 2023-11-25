import java.io.*;

//백준 5598 카이사르 암호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        char temp;
        for(int i = 0; i < str.length(); i++){
            temp = str.charAt(i);
            if((int)temp <= 67) bw.write(temp+23);
            else bw.write(temp-3);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}