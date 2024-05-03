import java.io.*;
import java.util.*;

//3035 스캐너
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int zr = Integer.parseInt(st.nextToken());
        int zc = Integer.parseInt(st.nextToken());

        String temp;
        char letter;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < r; i++){
            temp = br.readLine();
            for(int x = 0; x < zr; x++) {
                for (int j = 0; j < c; j++) {
                    letter = temp.charAt(j);
                    for (int y = 0; y < zc; y++) {
                        result.append(letter);
                    }
                }
                result.append("\n");
            }
        }
        bw.write(result.toString());
        bw.flush();
    }
}
