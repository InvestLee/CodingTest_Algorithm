import java.io.*;
import java.util.*;

//5576 콘테스트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[] w = new Integer[10];
        Integer[] k = new Integer[10];
        for(int i = 0; i < 10; i++) w[i] = Integer.parseInt(br.readLine());
        for(int i = 0; i < 10; i++) k[i] = Integer.parseInt(br.readLine());

        Arrays.sort(w, Collections.reverseOrder());
        Arrays.sort(k, Comparator.reverseOrder());

        int wResult = w[0]+w[1]+w[2];
        int kResult = k[0]+k[1]+k[2];

        bw.write(wResult+" "+kResult);
        bw.flush();
        bw.close();
        br.close();
    }
}