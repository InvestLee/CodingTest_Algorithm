import java.io.*;
import java.util.*;

//백준 24511 queuestack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] queueOrStack = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) queueOrStack[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int number;
        for(int i = 0; i < n; i++){
            number = Integer.parseInt(st.nextToken());
            if(queueOrStack[i] == 0) deque.addLast(number);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            deque.addFirst(Integer.parseInt(st.nextToken()));
            bw.write(deque.pollLast()+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}