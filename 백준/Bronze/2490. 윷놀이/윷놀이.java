import java.io.*;
import java.util.*;

//백준 2490 윷놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int playNum;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            playNum = 4;
            for(int j = 0; j < 4; j++){
                playNum -= Integer.parseInt(st.nextToken());
            }
            if(playNum == 0) bw.write("E\n");
            else bw.write((char)(playNum+64)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}