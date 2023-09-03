import java.io.*;
import java.util.*;

//백준 28279 덱 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        String[] command;
        for(int i = 0; i < n; i++){
            command = br.readLine().split(" ");
            if(command[0].equals("1")){
                deque.addFirst(command[1]);
            } else if(command[0].equals("2")){
                deque.addLast(command[1]);
            } else if(command[0].equals("3")){
                if(!deque.isEmpty()) bw.write(deque.pollFirst()+"\n");
                else bw.write(-1+"\n");
            } else if(command[0].equals("4")){
                if(!deque.isEmpty()) bw.write(deque.pollLast()+"\n");
                else bw.write(-1+"\n");
            } else if(command[0].equals("5")){
                bw.write(deque.size()+"\n");
            } else if(command[0].equals("6")){
                if(!deque.isEmpty()) bw.write(0+"\n");
                else bw.write(1+"\n");
            } else if(command[0].equals("7")){
                if(!deque.isEmpty()) bw.write(deque.peekFirst()+"\n");
                else bw.write(-1+"\n");
            } else {
                if(!deque.isEmpty()) bw.write(deque.peekLast()+"\n");
                else bw.write(-1+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}