import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num = (int) Math.round(n * 0.15);
        double result = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) arr.add(Integer.parseInt(br.readLine()));
        arr.sort(Comparator.naturalOrder());
        for(int i = num; i < n-num; i++) result += arr.get(i);
        bw.write((int) Math.round(result / (n-2*num))+"");
        bw.flush();
        bw.close();
    }
}
