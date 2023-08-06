import java.io.*;
import java.util.*;

//백준 1339 단어 수학
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];
        int[] alpha = new int[26];
        for(int i = 0; i < n; i++) word[i] = br.readLine();

        int power;
        for(int i = 0; i < n; i++){
            power = (int) Math.pow(10,word[i].length()-1);
            for(int j = 0; j < word[i].length(); j++){
                alpha[(int)word[i].charAt(j)-65] += power;
                power /= 10;
            }
        }

        Arrays.sort(alpha);
        int result = 0;
        int num = 9;
        for(int i = alpha.length-1; i >= 0; i--){
            if(alpha[i] == 0) break;
            result += alpha[i]*num;
            num--;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
