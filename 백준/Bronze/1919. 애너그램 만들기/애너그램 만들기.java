import java.io.*;

//백준 1919 애너그램 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String wordA = br.readLine();
        String wordB = br.readLine();
        int[] alphaA = new int[26];
        int[] alphaB = new int[26];
        for(int i = 0; i < wordA.length(); i++) alphaA[wordA.charAt(i) - 'a']++;
        for(int i = 0; i < wordB.length(); i++) alphaB[wordB.charAt(i) - 'a']++;

        int result = 0;
        for(int i = 0; i < 26; i++) result += Math.abs(alphaA[i] - alphaB[i]);

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}