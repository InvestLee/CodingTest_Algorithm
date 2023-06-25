import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) hashSet.add(br.readLine());
        StringBuilder sb;
        int wordLen;
        for(String word : hashSet){
            sb = new StringBuilder(word);
            if(hashSet.contains(sb.reverse().toString())){
                wordLen = word.length();
                bw.write(wordLen+" ");
                bw.write(word.charAt(wordLen/2)+"");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
