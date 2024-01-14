import java.io.*;

//1769 3의 배수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int cnt = 0;
        long num = 0;

        while(true){
            num = 0;
            if(str.length() == 1) break;
            for(int i = 0; i < str.length(); i++){
                num += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            str = String.valueOf(num);
            cnt++;
        }

        bw.write(cnt+"\n");
        if(Integer.parseInt(String.valueOf(str)) % 3 == 0) bw.write("YES");
        else bw.write("NO");
        bw.flush();
        bw.close();
        br.close();
    }
}