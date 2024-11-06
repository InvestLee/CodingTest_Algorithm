import java.util.*;

class Food{
    int time;
    int num;
    
    public Food(int time, int num){
        this.time = time;
        this.num = num;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long total = 0;
        for(int i = 0; i < food_times.length; i++){
            total += food_times[i];
        }
        if(total <= k) return -1;
        PriorityQueue<Food> pq = new PriorityQueue<>((o1,o2)->o1.time-o2.time);
        for(int i = 0; i < food_times.length; i++){
            pq.offer(new Food(food_times[i], i+1));
        }
        long usedTime = 0;
        long preTime = 0 ;
        long foodCnt = food_times.length;
        while(usedTime + (pq.peek().time - preTime)*foodCnt <= k){
            Food nowFood = pq.poll();
            usedTime += (nowFood.time - preTime) * foodCnt;
            foodCnt--;
            preTime = nowFood.time;
        }
        
        ArrayList<Food> answer = new ArrayList<>();
        while(!pq.isEmpty()){
            answer.add(pq.poll());
        }
        answer.sort((o1,o2)->(o1.num-o2.num));
        
        return answer.get((int)((k-usedTime)%foodCnt)).num;
    }
}