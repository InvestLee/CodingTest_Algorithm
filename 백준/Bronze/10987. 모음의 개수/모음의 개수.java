import java.io.*;

//10987 모음의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int result = str.length();
        str = str.replaceAll("a","");
        str = str.replaceAll("e","");
        str = str.replaceAll("i","");
        str = str.replaceAll("o","");
        str = str.replaceAll("u","");

        bw.write(result - str.length()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}