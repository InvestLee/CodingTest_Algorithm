import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, a, b, shape;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String result;
        HashMap<Integer, Integer> aMap, bMap;
        while(n-- > 0){
            aMap = new HashMap<>();
            bMap = new HashMap<>();
            for(int i = 1; i <= 4; i++){
                aMap.put(i,0);
                bMap.put(i,0);
            }

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            for(int i = 0; i < a; i++){
                shape = Integer.parseInt(st.nextToken());
                aMap.put(shape,aMap.get(shape)+1);
            }

            st = new StringTokenizer(br.readLine());
            b = Integer.parseInt(st.nextToken());
            for(int i = 0; i < b; i++){
                shape = Integer.parseInt(st.nextToken());
                bMap.put(shape,bMap.get(shape)+1);
            }

            result = "D";
            for(int i = 4; i > 0; i--){
                if(aMap.get(i) > bMap.get(i)) {
                    result = "A";
                    break;
                } else if (aMap.get(i) < bMap.get(i)) {
                    result = "B";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
