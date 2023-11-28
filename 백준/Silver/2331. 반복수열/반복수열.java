import java.io.*;
import java.util.*;

//백준 2331 반복수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int p = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        int num, total;
        while(true){
            hashMap.put(a,hashMap.getOrDefault(a,0)+1);
            if(hashMap.get(a) == 3) break;

            total = 0;
            for(int i = 0; i < a.length(); i++){
                num = a.charAt(i) - '0';
                total += Math.pow(num,p);
            }
            a = String.valueOf(total);
        }

        int result = 0;
        for(int isOne : hashMap.values()){
            if(isOne == 1) result++;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}