import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int num = n;
        HashSet<Integer> hashSet = new HashSet<>();
        while(true){
            hashSet.add(num);
            num =  (num*n) % p;
            if(hashSet.contains(num)) break;
        }
        hashSet = new HashSet<>();
        while(true){
            hashSet.add(num);
            num =  (num*n) % p;
            if(hashSet.contains(num)) break;
        }
        System.out.println(hashSet.size());
    }
}
