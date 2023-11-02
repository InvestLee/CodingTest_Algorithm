import java.io.*;

//백준 4375 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n, mod;
        while((str = br.readLine()) != null){
            n = Integer.parseInt(str);
            mod = 0;
            for(int i = 1;; i++) {
                mod = (mod * 10 + 1) % n;
                if (mod == 0) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}