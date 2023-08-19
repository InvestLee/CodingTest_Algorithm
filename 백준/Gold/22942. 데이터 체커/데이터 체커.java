import java.io.*;
import java.util.*;

//백준 22492 데이터 체커
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> circles = new ArrayList<>();
        StringTokenizer st;

        int x, r;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            circles.add(new int[]{x - r, x + r});
        }

        circles.sort((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int[] previous = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        String result = "YES";
        for(int[] circle : circles){
            if(previous[1] >= circle[0] && previous[1] <= circle[1]){
                result = "NO";
                break;
            }
            previous = circle;
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
