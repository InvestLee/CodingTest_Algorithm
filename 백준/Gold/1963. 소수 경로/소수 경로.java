import java.util.*;
import java.io.*;

public class Main {
    static class changeNum{
        int num, count;
        public changeNum(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static boolean[] decimal = new boolean[10000];	//1000~9999 소수 확인 배열
    static public void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=2;i<10000;i++){
            if(!decimal[i]){
                for(int j=i*2;j<10000;j+=i){
                    decimal[j] = true;
                }
            }
        }
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            int result = bfs(cur,goal);
            if(result == -1)	
                bw.write("Impossible\n");
            else		
                bw.write(result + "\n");
        }
        bw.flush();	
        bw.close();
        br.close();
    }
    static int bfs(int start, int goal){
        Queue<changeNum> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        visited[start] = true;
        queue.add(new changeNum(start, 0));
        while(!queue.isEmpty()){
            changeNum cur = queue.poll();
            int num = cur.num;
            int count = cur.count;
            if(num==goal)	
                return count;

            int n = num/10 * 10;
            for(int i=0;i<10;i++){
                int temp = n + i;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            n = (num/100 * 100) + (num%10);
            for(int i=0;i<10;i++){
                int temp = n + i*10;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            n = (num/1000 * 1000) + (num%100);
            for(int i=0;i<10;i++){
                int temp = n + i*100;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            n = num%1000;
            for(int i=1;i<10;i++){
                int temp = n + i*1000;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
        }
        return -1;
    }
}