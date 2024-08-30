import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        String[] starts, ends;
        int start, end;
        int[][] bookTime = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++){
            starts = book_time[i][0].split(":");
            ends = book_time[i][1].split(":");
            
            start = Integer.parseInt(starts[0]) * 60 
                + Integer.parseInt(starts[1]);
            end = Integer.parseInt(ends[0]) * 60 
                + Integer.parseInt(ends[1]) + 10;
            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }
        
        Arrays.sort(bookTime, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for(int[] book : bookTime){
            if(pq.isEmpty()){
                pq.add(book);
            } else {
                int[] temp = pq.peek();
                if(book[0] >= temp[1]){
                    pq.poll();
                }
                pq.add(book);
            }
        }
        
        int answer = pq.size();
        return answer;
    }
}