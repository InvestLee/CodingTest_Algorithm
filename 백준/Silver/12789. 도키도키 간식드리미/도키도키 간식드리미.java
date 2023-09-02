import java.io.*;
import java.util.*;

//백준 12789 도키도키 간식드리미
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> waiting = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        int curNum = 1;
        for(int i = 0; i < n; i++){
            num = Integer.parseInt(st.nextToken());
            if(num == curNum){
                curNum++;
                while(!waiting.isEmpty() && waiting.peek() == curNum){
                    waiting.pop();
                    curNum++;
                }
            }
            else waiting.add(num);
        }
        if(curNum == n + 1) bw.write("Nice");
        else bw.write("Sad");
        bw.flush();
        br.close();
        bw.close();
    }
}