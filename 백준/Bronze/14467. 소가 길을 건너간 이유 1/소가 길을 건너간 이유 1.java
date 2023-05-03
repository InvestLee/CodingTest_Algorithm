import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st;
        int cow, location;
        while (n-- > 0){
            st = new StringTokenizer(br.readLine());
            cow = Integer.parseInt(st.nextToken());
            location = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(cow)) hashMap.put(cow, location);
            else if(hashMap.get(cow) != location){
                hashMap.put(cow, location);
                result++;
            }
        }
        System.out.println(result);
    }
}
