import java.io.*;

//백준 10769 행복한지 슬픈지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int smile = (str.length() - str.replace(":-)", "").length()) / 3;
        int sad = (str.length() - str.replace(":-(", "").length()) / 3;

        if(smile == 0 && sad == 0) bw.write("none");
        else if(smile == sad) bw.write("unsure");
        else if(smile > sad) bw.write("happy");
        else bw.write("sad");

        bw.flush();
        br.close();
        bw.close();
    }
}