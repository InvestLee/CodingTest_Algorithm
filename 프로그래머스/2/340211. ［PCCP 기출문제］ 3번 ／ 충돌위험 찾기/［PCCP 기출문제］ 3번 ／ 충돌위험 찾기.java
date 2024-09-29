import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length;
        int x = routes.length;
        int m = routes[0].length;
        int t = 0;
        int[][] cur = new int[x][2];
        int[][][] dist = new int[x][m-1][2];
        int[] idx = new int[x];
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        String temp;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < m; j++){
                routes[i][j]--;
            }
            cur[i][0] = points[routes[i][0]][0];
            cur[i][1] = points[routes[i][0]][1];
            temp = cur[i][0]+" "+cur[i][1];
            hashMap.put(temp, hashMap.getOrDefault(temp, 0)+1);
        }
        
        for(int v : hashMap.values()){
            if(v > 1) answer++;
        }
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < m-1; j++){
                dist[i][j][0] = points[routes[i][j+1]][0] 
                    - points[routes[i][j]][0];
                dist[i][j][1] = points[routes[i][j+1]][1] 
                    - points[routes[i][j]][1];
            }
        }
        
        int endCnt = 0;
        while(endCnt < x){
            hashMap = new HashMap<>();
            endCnt = 0;
            for(int i = 0; i < x; i++){
                if(dist[i][idx[i]][0] == 0 
                   && dist[i][idx[i]][1] == 0){
                    if(idx[i] < m-2) {
                        idx[i]++;
                    } else {
                        endCnt++;
                        continue;
                    }
                }
                
                if(dist[i][idx[i]][0] > 0){
                    cur[i][0]++;
                    dist[i][idx[i]][0]--;
                } else if(dist[i][idx[i]][0] < 0){
                    cur[i][0]--;
                    dist[i][idx[i]][0]++;
                } else if(dist[i][idx[i]][1] > 0){
                    cur[i][1]++;
                    dist[i][idx[i]][1]--;
                } else if(dist[i][idx[i]][1] < 0){
                    cur[i][1]--;
                    dist[i][idx[i]][1]++;
                }
                temp = cur[i][0]+" "+cur[i][1];
                hashMap.put(temp, hashMap.getOrDefault(temp, 0)+1);
            }
            
            for(int v : hashMap.values()){
                if(v > 1) answer++;
            }
        }
        
        return answer;
    }
}