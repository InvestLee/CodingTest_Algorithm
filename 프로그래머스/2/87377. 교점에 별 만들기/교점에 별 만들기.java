import java.util.*;

class Solution {
    
    public static ArrayList<Point> interactions = new ArrayList<>();
    public static long minX = Long.MAX_VALUE;
    public static long minY = Long.MAX_VALUE;
    public static long maxX = Long.MIN_VALUE;
    public static long maxY = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i+1; j < line.length; j++){
                getInteraction(line[i], line[j]);
            }
        }
        
        for(Point point : interactions){
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
        }
        
        long r = maxY - minY + 1;
        long c = maxX - minX + 1;
        
        String[] answer = new String[(int)r];
        boolean[][] board = new boolean[(int)r][(int)c];
        
        for(Point point : interactions){
            board[(int)(maxY - point.y)][(int)(point.x - minX)] = true;
        }
        
        int idx = 0;
        String temp;
        for(int i = 0; i < board.length; i++){
            temp = "";
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]){
                    temp += "*";
                } else {
                    temp += ".";
                }
            }
            answer[idx++] = temp;
        }
        
        return answer;
    }
    
    public static void getInteraction(int[] l1, int[] l2){
        
        long d = (long)l1[0]*l2[1]-l2[0]*l1[1];
        if(d == 0){
            return;
        }
        
        long x = (long)l1[1]*l2[2]-l2[1]*l1[2];
        long y = (long)l1[2]*l2[0]-l2[2]*l1[0];
        if((x % d != 0) || (y % d != 0)) {
            return;
        }   
        
        interactions.add(new Point(x/d, y/d));
    }
}

class Point{
    public long x;
    public long y;
    
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}