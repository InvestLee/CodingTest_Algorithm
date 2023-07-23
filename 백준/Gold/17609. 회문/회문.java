import java.io.*;

//백준 17609 회문
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int cnt;
        StringBuilder sb, lsb, rsb;

        while(t-- > 0){
            sb = new StringBuilder(br.readLine());
            if(sb.toString().equals(sb.reverse().toString())){
                bw.write("0\n");
                continue;
            }

            cnt = sb.length() / 2 + sb.length() % 2;
            for(int i = 0; i < cnt; i++){
                if(sb.charAt(i) != sb.charAt(sb.length()-1-i)){
                    lsb = new StringBuilder(sb.substring(0,i)+sb.substring(i+1,sb.length()));
                    rsb = new StringBuilder(sb.substring(0,sb.length()-1-i)+sb.substring(sb.length()-i,sb.length()));
                    if(lsb.toString().equals(lsb.reverse().toString()) ||
                            rsb.toString().equals(rsb.reverse().toString())){
                        bw.write("1\n");
                    } else {
                        bw.write("2\n");
                    }
                    break;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
