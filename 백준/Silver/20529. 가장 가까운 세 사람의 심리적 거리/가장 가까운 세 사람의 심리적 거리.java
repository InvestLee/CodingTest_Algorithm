import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, result, distance;
        String[] mbti;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            mbti = new String[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) mbti[i] = st.nextToken();
            if(n > 32) bw.write(0+"\n");
            else{
                for(int i = 0; i < n; i++){
                    for(int j = i+1; j < n; j++){
                        for(int k = j+1; k < n; k++){
                            distance = 0;
                            for(int x = 0; x < 4; x++){
                                if(mbti[i].charAt(x) != mbti[j].charAt(x)) distance++;
                                if(mbti[j].charAt(x) != mbti[k].charAt(x)) distance++;
                                if(mbti[k].charAt(x) != mbti[i].charAt(x)) distance++;
                            }
                            result = Math.min(result,distance);
                        }
                    }
                }
                bw.write(result+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}