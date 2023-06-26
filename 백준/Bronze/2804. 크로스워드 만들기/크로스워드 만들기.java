import java.io.*;
import java.util.*;

public class Main {

    public static String a, b;
    public static int idxA, idxB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();
        char[][] crossword = new char[b.length()][a.length()];
        equalChar();
        for(int i = 0; i < b.length(); i++) Arrays.fill(crossword[i],'.');
        for(int i = 0; i < a.length(); i++) crossword[idxB][i] = a.charAt(i);
        for(int i = 0; i < b.length(); i++) crossword[i][idxA] = b.charAt(i);

        for(int i = 0; i < b.length(); i++){
            for(int j = 0; j < a.length(); j++){
                bw.write(crossword[i][j]+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void equalChar(){
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    idxA = i;
                    idxB = j;
                    return;
                }
            }
        }
    }
}
