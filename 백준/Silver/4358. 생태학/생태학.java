import java.io.*;
import java.util.*;

//4358 생태학
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int total = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        while((str = br.readLine()) != null){
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            total++;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for(String key : hashMap.keySet()){
            arrayList.add(key);
        }
        arrayList.sort(Comparator.naturalOrder());

        int cal;
        for(String tree : arrayList){
            cal = hashMap.get(tree) * 100;
            bw.write(tree + " " + String.format("%.4f", (double) cal / (double) total) + "\n");
        }
        bw.flush();
    }
}
