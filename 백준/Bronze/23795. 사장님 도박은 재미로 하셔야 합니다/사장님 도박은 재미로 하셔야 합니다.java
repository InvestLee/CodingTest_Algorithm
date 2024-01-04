import java.io.*;

//23795 사장님 도박은 재미로 하셔야 합니다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int val;

        while(true){
            val = Integer.parseInt(br.readLine());
            if(val == -1) break;
            result += val;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}