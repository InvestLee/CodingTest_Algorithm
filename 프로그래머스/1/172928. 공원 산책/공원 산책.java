class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int[] answer = new int[2];
        int r = park.length;
        int c = park[0].length();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        char dir;
        int dist;
        int idx, backX, backY;
        for(int i = 0; i < routes.length; i++){
            dir = routes[i].charAt(0);
            dist = routes[i].charAt(2) - '0';
            if(dir == 'N') idx = 0;
            else if(dir == 'S') idx = 1;
            else if(dir == 'W') idx = 2;
            else idx = 3;
            
            backX = answer[0];
            backY = answer[1];
            while(dist-- > 0){
                answer[0] = answer[0] + dx[idx];
                answer[1] = answer[1] + dy[idx];
                if(answer[0] < 0 || answer[1] < 0 
                  || answer[0] >= r || answer[1] >= c
                  || park[answer[0]].charAt(answer[1]) == 'X'){
                    answer[0] = backX;
                    answer[1] = backY;
                    break;
                };
            }
        }
        return answer;
    }
}