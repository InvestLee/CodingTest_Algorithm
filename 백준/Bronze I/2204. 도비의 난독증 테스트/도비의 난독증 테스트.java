import java.io.*;
import java.util.*;

//2204 도비의 난독증 테스트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n;
        ArrayList<String> wordList;

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            wordList = new ArrayList<>();
            for(int i = 0; i < n; i++) wordList.add(br.readLine());
            wordList.sort(String::compareToIgnoreCase);
            bw.write(wordList.get(0)+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}