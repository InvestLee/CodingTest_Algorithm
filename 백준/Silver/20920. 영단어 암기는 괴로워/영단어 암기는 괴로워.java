import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        String w;
        while(n-- > 0){
            w = br.readLine();
            if (w.length() < m) continue;
            if (!hashMap.containsKey(w)) hashMap.put(w, 0);
            else hashMap.put(w, hashMap.get(w)+1);
        }
        ArrayList<String> arr = new ArrayList<>(hashMap.keySet());

        arr.sort((o1, o2) -> {
            int c1 = hashMap.get(o1);
            int c2 = hashMap.get(o2);
            if(c1 == c2){
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o2.length()-o1.length();
            } return c2-c1;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) sb.append(arr.get(i)).append("\n");
        System.out.println(sb);
    }
}