import java.io.*;
import java.util.*;

//1969 DNA
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] str = new String[n];
        for(int i = 0; i < n; i++) str[i] = br.readLine();

        String result = "";
        char temp = ' ';
        HashMap<Character, Integer> hashMap;
        int maxCnt;
        int resultSum = 0;
        for(int i = 0; i < m; i++){
            hashMap = new HashMap<>();
            for(int j = 0; j < n; j++){
                hashMap.put(str[j].charAt(i), hashMap.getOrDefault(str[j].charAt(i),0)+1);
            }

            maxCnt = 0;
            for(char k : hashMap.keySet()){
                if(maxCnt < hashMap.get(k)){
                    maxCnt = hashMap.get(k);
                    temp = k;
                } else if(maxCnt == hashMap.get(k)){
                    if(temp > k) temp = k;
                }
            }
            result += temp;
            resultSum += n - maxCnt;
        }

        bw.write(result+"\n"+resultSum);
        bw.flush();
        bw.close();
        br.close();
    }
}