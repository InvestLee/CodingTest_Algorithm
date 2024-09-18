import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Plan[] plan = new Plan[plans.length];
        for(int i = 0; i < plans.length; i++){
            plan[i] = new Plan(plans[i]);
        }
        Arrays.sort(plan, (o1,o2)-> o1.start - o2.start);
        
        Stack<Plan> stack = new Stack<>();
        Queue<String> result = new LinkedList<>();
        Plan cur, next, restart;
        int rest;
        for(int i = 0; i < plans.length -1; i++){
            cur = plan[i];
            next = plan[i+1];
            if(cur.getEndTime() > next.start){
                cur.playTime = cur.getEndTime() - next.start;
                stack.push(cur);
                continue;
            }
            result.offer(cur.name);
            
            rest = next.start - cur.getEndTime();
            while(rest > 0 && !stack.isEmpty()){
                restart = stack.peek();
                restart.playTime -= rest;
                rest = restart.playTime * -1;
                if(restart.playTime > 0) break;
                result.offer(stack.pop().name);
            }
        }
        
        result.offer(plan[plan.length - 1].name);
        while(!stack.isEmpty()) result.offer(stack.pop().name);
        for(int i = 0; i < plans.length; i++){
            answer[i] = result.poll();
        }
        return answer;
    }
}

class Plan{
    String name;
    int start;
    int playTime;
    
    public Plan(String name, String start, String playTime){
        this.name = name;
        String[] t = start.split(":");
        this.start = Integer.parseInt(t[0])*60 
            + Integer.parseInt(t[1]);
        this.playTime = Integer.parseInt(playTime);
    }
    
    public Plan(String[] plan){
        this(plan[0], plan[1], plan[2]);
    }
    
    public int getEndTime(){
        return start + playTime;
    }
}