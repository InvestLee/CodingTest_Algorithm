import java.io.*;
import java.util.*;

//20291 파일 정리
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] str;
        for(int i = 0; i < n; i++){
            str = br.readLine().split("\\.");
            hashMap.put(str[1], hashMap.getOrDefault(str[1],0)+1);
        }

        ArrayList<String> arr = new ArrayList<>(hashMap.keySet());
        arr.sort(Comparator.naturalOrder());
        for(int i = 0; i < arr.size(); i++){
            bw.write(arr.get(i) + " " + hashMap.get(arr.get(i))+"\n");
        }
        bw.flush();
    }
}
