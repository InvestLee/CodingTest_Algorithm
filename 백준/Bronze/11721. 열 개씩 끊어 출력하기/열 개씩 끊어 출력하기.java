import java.io.*;

//백준 11721 열 개 씩 끊어 출력하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        for(int i = 0; i < line.length(); i++){
            bw.write(line.charAt(i)+"");
            if(i%10 == 9) bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}