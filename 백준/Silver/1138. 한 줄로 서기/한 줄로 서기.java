import java.io.*;
import java.util.*;

//백준 1138 한 줄로 서기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] tallerPerson = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) tallerPerson[i] = Integer.parseInt(st.nextToken());

        List<Integer> result = new LinkedList<>();
        for(int i = n; i >= 1; i--) result.add(tallerPerson[i], i);

        for(int i : result) bw.write(i+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}