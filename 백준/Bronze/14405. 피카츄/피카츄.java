import java.io.*;

//14405 피카츄
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        s = s.replaceAll("pi","Z");
        s = s.replaceAll("ka","Z");
        s = s.replaceAll("chu","Z");
        s = s.replaceAll("Z","");
        if(s.length() > 0) bw.write("NO");
        else bw.write("YES");

        bw.flush();
        bw.close();
        br.close();
    }
}