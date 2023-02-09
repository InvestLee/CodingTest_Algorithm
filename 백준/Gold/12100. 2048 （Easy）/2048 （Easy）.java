import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int count){
        if(count==5){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) result = Math.max(result,graph[i][j]);
            }
            return;
        }
        int[][] initGraph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) initGraph[i][j] = graph[i][j];
        }
        for(int i=0; i<4; i++){
            moveBlock(i);
            dfs(count+1);
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++) graph[j][k] = initGraph[j][k];
            }
        }
    }

    public static void moveBlock(int idx){
        Queue<Integer> q = new LinkedList<>();
        switch (idx){
            case 0: //위
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if (graph[j][i] != 0) q.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                    int location = 0;
                    while(!q.isEmpty()){
                        int nowBlock = q.poll();
                        if(graph[location][i] == 0) graph[location][i] = nowBlock;
                        else if(graph[location][i] == nowBlock) {
                            graph[location][i] = nowBlock * 2;
                            location++;
                        } else {
                            location++;
                            graph[location][i] = nowBlock;
                        }
                    }
                }
                break;
            case 1: //아래
                for(int i = 0; i < n; i++){
                    for(int j = n-1; j >= 0; j--){
                        if (graph[j][i] != 0) q.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                    int location = n-1;
                    while(!q.isEmpty()){
                        int nowBlock = q.poll();
                        if(graph[location][i] == 0) graph[location][i] = nowBlock;
                        else if(graph[location][i] == nowBlock) {
                            graph[location][i] = nowBlock * 2;
                            location--;
                        } else {
                            location--;
                            graph[location][i] = nowBlock;
                        }
                    }
                }
                break;
            case 2: //왼쪽
                for(int i = 0; i < n; i++){
                    for(int j = n-1; j >= 0; j--){
                        if (graph[i][j] != 0) q.add(graph[i][j]);
                        graph[i][j] = 0;
                    }
                    int location = n-1;
                    while(!q.isEmpty()){
                        int nowBlock = q.poll();
                        if(graph[i][location] == 0) graph[i][location] = nowBlock;
                        else if(graph[i][location] == nowBlock) {
                            graph[i][location] = nowBlock * 2;
                            location--;
                        } else {
                            location--;
                            graph[i][location] = nowBlock;
                        }
                    }
                }
                break;
            case 3: //오른쪽
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if (graph[i][j] != 0) q.add(graph[i][j]);
                        graph[i][j] = 0;
                    }
                    int location = 0;
                    while(!q.isEmpty()){
                        int nowBlock = q.poll();
                        if(graph[i][location] == 0) graph[i][location] = nowBlock;
                        else if(graph[i][location] == nowBlock) {
                            graph[i][location] = nowBlock * 2;
                            location++;
                        } else {
                            location++;
                            graph[i][location] = nowBlock;
                        }
                    }
                }
                break;
        }
    }
}