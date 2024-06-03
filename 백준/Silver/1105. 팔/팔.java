import java.io.*;
import java.util.StringTokenizer;

//1105 팔
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        int result = 0;
        if(l.length() == r.length()){
            for(int i = 0; i < l.length(); i++){
                if(l.charAt(i) != r.charAt(i)) break;
                else{
                    if(l.charAt(i) == '8') result++;
                }
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}