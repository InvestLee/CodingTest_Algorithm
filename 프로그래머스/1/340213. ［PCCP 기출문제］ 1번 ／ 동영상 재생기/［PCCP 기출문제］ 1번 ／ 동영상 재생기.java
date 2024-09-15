import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoLen = trans(video_len);
        int posSec =  trans(pos);
        int opStart = trans(op_start);
        int opEnd = trans(op_end);
        
        for(String c : commands){
            if(opStart <= posSec && posSec <= opEnd){
                posSec = opEnd;
            }
            
            if(c.equals("prev")){
                if(posSec < 10){
                    posSec = 0;
                } else {
                    posSec -= 10;
                }
            } else {
                if(posSec > videoLen-10){
                    posSec = videoLen;
                } else {
                    posSec += 10;
                }
            }
            
            if(opStart <= posSec && posSec <= opEnd){
                posSec = opEnd;
            }
        }
        
        answer = String.format("%02d", posSec / 60) 
            + ":" + String.format("%02d", posSec % 60);
        return answer;
    }
    
    public static int trans(String t){
        String[] time = t.split(":");
        int transTime = Integer.parseInt(time[0]) * 60 
            + Integer.parseInt(time[1]);
        return transTime;
    }
}