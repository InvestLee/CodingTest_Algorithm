class Solution {
    public int solution(int n, int w, int num) {
        int floor = num / w;
        int loc;
        if(floor % 2 == 0) loc = (w+num-1) % w;
        else loc = w - ((w+num-1) % w) - 1;
        int answer = 1;
        while(num <= n){
            if(floor % 2 == 0) num += 2 * (w-loc)-1;
            else num += loc * 2 + 1;
            answer++;
            floor++;
        }
        return answer-1;
    }
}