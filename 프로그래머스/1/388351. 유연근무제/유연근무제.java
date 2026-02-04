class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int curday, cnt, schedulestransfer, timetransfer;
        for(int i = 0; i < schedules.length; i++){
            cnt = 0;
            schedulestransfer = schedules[i] / 100 * 60 + schedules[i] % 100;
            for(int j = 0; j < timelogs[i].length; j++){            
                curday = (startday + j + 1) % 7;
                if(curday < 2) continue;
                timetransfer = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                if(timetransfer-schedulestransfer <= 10) cnt++;
            }
            if(cnt == 5) answer++;
        }
        return answer;
    }
}