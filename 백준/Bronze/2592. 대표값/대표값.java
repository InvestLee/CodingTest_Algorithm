import java.io.*;
import java.util.HashMap;

//백준 2592 대표값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int num;
        int result = 0;
        for(int i = 0; i < 10; i++){
            num = Integer.parseInt(br.readLine());
            result += num;
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        bw.write((result/10)+"\n");

        int max = 0;
        for(int k : hashMap.keySet()){
            if(hashMap.get(k) > max){
                result = k;
                max = hashMap.get(k);
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}