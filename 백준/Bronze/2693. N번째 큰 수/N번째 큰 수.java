import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr;
        StringTokenizer st;
        for (int i = 0; i < t; i++){
            arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr);
            System.out.println(arr.get(7));
        }
    }
}