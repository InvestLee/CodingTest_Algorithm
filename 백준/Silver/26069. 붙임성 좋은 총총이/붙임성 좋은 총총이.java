import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String a, b;
        HashMap<String, Integer> hashMap = new HashMap<>();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if (!hashMap.containsKey(a)) hashMap.put(a, 0);
            if (!hashMap.containsKey(b)) hashMap.put(b, 0);
            if (a.equals("ChongChong") || hashMap.get(b) == 1) hashMap.put(a,1);
            if (b.equals("ChongChong") || hashMap.get(a) == 1) hashMap.put(b,1);
            if (a.equals("ChongChong") || hashMap.get(b) == 1) hashMap.put(a,1);
        }
        int result = 0;
        for (int i : hashMap.values()) result += i;
        System.out.println(result);
    }
}
