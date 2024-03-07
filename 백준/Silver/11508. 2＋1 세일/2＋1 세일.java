import java.io.*;
import java.util.*;

//11508 2+1 세일
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] items = new Integer[n];

        for(int i = 0; i < n; i++) items[i] = Integer.parseInt(br.readLine());
        Arrays.sort(items, Comparator.reverseOrder());

        int result = 0;
        for(int i = 0; i < n; i++){
            if(i % 3 == 2) continue;
            result += items[i];
        }
        bw.write(result+"");
        bw.flush();
    }
}