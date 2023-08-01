import java.io.*;

//백준 1013 Contact
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vega = "(100+1+|01)+";
        String pattern;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            pattern = br.readLine();
            if(pattern.matches(vega)) bw.write("YES\n");
            else bw.write("NO\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
