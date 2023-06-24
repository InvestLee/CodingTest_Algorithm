import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int num;
        for(int i = 1; i <= n; i++){
            num = Integer.parseInt(st.nextToken());
            if(num == 0) arr.add(i);
            else arr.add(arr.size()-num,i);
        }

        for(int i = 0; i < n; i++) bw.write(arr.get(i)+" ");
        bw.flush();
        bw.close();
    }
}
