import java.io.*;
import java.util.*;

//백준 28278 스택 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        String[] command;
        for(int i = 0; i < n; i++){
            command = br.readLine().split(" ");
            if(command[0].equals("1")){
                stack.push(command[1]);
            } else if(command[0].equals("2")){
                if(!stack.isEmpty()) bw.write(stack.pop()+"\n");
                else bw.write(-1+"\n");
            } else if(command[0].equals("3")){
                bw.write(stack.size()+"\n");
            } else if(command[0].equals("4")){
                if(!stack.isEmpty()) bw.write(0+"\n");
                else bw.write(1+"\n");
            } else {
                if(!stack.isEmpty()) bw.write(stack.peek()+"\n");
                else bw.write(-1+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}