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
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.get(k-1));
    }
}