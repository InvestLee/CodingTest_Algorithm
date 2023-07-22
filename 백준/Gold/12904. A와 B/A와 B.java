import java.io.*;

//백준 12904 A와 B
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());
        while(s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else{
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        if(s.toString().equals(t.toString())) bw.write(1+"");
        else bw.write(0+"");
        br.close();
        bw.flush();
        bw.close();
    }
}
