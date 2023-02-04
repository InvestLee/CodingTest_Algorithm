import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int j;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            j = 1;
            while(i*j <= n){
                if(!arr.contains(i*j)) arr.add(i*j);
                j++;
            }
        }
        System.out.println(arr.get(k-1));
    }
}