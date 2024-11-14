import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int[][] sec = new int[lines.length][2];
        for(int i = 0; i < lines.length; i++){
            sec[i] = tran(lines[i]);
        }
        Arrays.sort(sec, (o1,o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        int answer = 0;
        for(int i = 0; i < sec.length; i++){
            for(int k = 0; k < 2; k++){
                int start = sec[i][k];
                int end = sec[i][k] + 999;
                int temp = 0;
                for(int j = 0; j < sec.length; j++){
                    if(start <= sec[j][1] && end >= sec[j][0]) temp++;
                }
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
    
    public static int[] tran(String date){
        String[] d = date.split(" ");
        String[] t1 = d[1].split(":");
        int t2 = (int)(Double.parseDouble(d[2].replace("s",""))*1000);
        int result = Integer.parseInt(t1[0]) * 3600 * 1000
                   + Integer.parseInt(t1[1]) * 60 * 1000
                   + (int)(Double.parseDouble(t1[2]) * 1000);
        return new int[]{result-t2+1,result};
    }  
}