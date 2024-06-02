import java.io.*;

//2607 비슷한 단어
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String temp, word = br.readLine();
        int cnt, result = 0;

        int[] arr;
        while(n-- > 1){
            temp = br.readLine();
            cnt = 0;
            arr = new int[26];
            for(int i = 0; i < word.length(); i++){
                arr[word.charAt(i) - 'A']++;
            }
            for(int i = 0; i < temp.length(); i++){
                if(arr[temp.charAt(i) - 'A'] > 0){
                    cnt++;
                    arr[temp.charAt(i) - 'A']--;
                }
            }

            if(word.length() == temp.length() && (word.length() == cnt || word.length() -1 == cnt)) result++;
            else if(word.length() == temp.length() - 1 && temp.length() - 1 == cnt) result++;
            else if(word.length() == temp.length() + 1 && temp.length() == cnt) result++;
        }
        bw.write(result+"");
        bw.flush();
    }
}