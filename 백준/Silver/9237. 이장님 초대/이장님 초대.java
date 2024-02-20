import java.io.*;
import java.util.*;

//9237 이장님 초대
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] tree = new Integer[n];
        for(int i = 0; i < n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree,Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            tree[i] += i + 2;
        }

        int result = Arrays.stream(tree).max(Integer::compare).get();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}