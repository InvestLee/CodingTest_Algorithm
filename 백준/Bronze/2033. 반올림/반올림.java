import java.io.*;

//2033 반올림
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int len = str.length() - 1;
        double num = Double.parseDouble(str);

        for(int i = 0; i < len; i++){
            num = Math.round(num / 10);
        }
        bw.write((int) (num * Math.pow(10,len))+"");
        bw.flush();
        bw.close();
        br.close();
    }
}