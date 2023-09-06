import java.io.*;
import java.util.*;

//백준 1655 가운데로 말해요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        int num, temp;
        for(int i = 0; i < n; i++){
            num = Integer.parseInt(br.readLine());
            if(maxPQ.size() == minPQ.size()){
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }

            if(!minPQ.isEmpty() && !maxPQ.isEmpty()){
                if(minPQ.peek() < maxPQ.peek()){
                    temp = minPQ.poll();
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(temp);
                }
            }
            bw.write(maxPQ.peek()+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}