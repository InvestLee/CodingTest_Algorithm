import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String document = br.readLine();
        String word = br.readLine();
        int wordLen = word.length();
        int index = 0;
        int result = 0;
        boolean equalWord;
        while(index+wordLen <= document.length()){
            equalWord = true;
            for(int i =  0; i < wordLen; i++){
                if(document.charAt(index+i) != word.charAt(i)){
                    equalWord = false;
                    break;
                }
            }
            if(equalWord){
                index +=  wordLen;
                result++;
            }
            else index++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
