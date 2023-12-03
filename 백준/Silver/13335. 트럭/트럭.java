import java.io.*;
import java.util.*;

//13335 트럭
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) truck.offer(Integer.parseInt(st.nextToken()));

        int result = 0;
        int weight = 0;

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++) bridge.add(0);

        while(!bridge.isEmpty()){
            result++;
            weight -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + weight <= l){
                    weight += truck.peek();
                    bridge.offer(truck.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
