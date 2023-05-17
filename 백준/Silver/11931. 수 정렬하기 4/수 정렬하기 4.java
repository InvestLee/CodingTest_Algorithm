import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while(n-- > 0) arr.add(Integer.parseInt(br.readLine()));
        arr.sort(Comparator.reverseOrder());
        for(int i = 0; i < arr.size(); i++) bw.write(arr.get(i)+"\n");
        bw.flush();
    }
}
