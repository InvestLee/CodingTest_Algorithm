import java.io.*;
import java.util.*;

//백준 17247 택시 거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    arr.add(i);
                    arr.add(j);
                }
            }
        }

        bw.write(Math.abs(arr.get(0)-arr.get(2))+Math.abs(arr.get(1)-arr.get(3))+"");
        br.close();
        bw.flush();
        bw.close();
    }
}