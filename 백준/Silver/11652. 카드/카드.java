import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hashMap = new HashMap<>();
        Long num;

        for(int i = 0; i < n; i++){
            num = Long.parseLong(br.readLine());
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        Long result = 0L;
        int maxValue = 0;
        for(long indexNum : hashMap.keySet()){
            if(maxValue < hashMap.get(indexNum)){
                maxValue = hashMap.get(indexNum);
                result = indexNum;
            } else if(maxValue == hashMap.get(indexNum)){
                if(result > indexNum) result = indexNum;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
