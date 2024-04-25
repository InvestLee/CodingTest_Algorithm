import java.io.*;

//15727 조별과제를 하려는데 조장이 사라졌다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        bw.write((int)Math.ceil((double)l/5)+"");
        bw.flush();
    }
}
