import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //여벌 체육복을 가진 학생이 도난당했을 경우를 생각하여 set으로 진행
        HashSet<Integer> set_reserve = new HashSet<>();
        HashSet<Integer> set_lost = new HashSet<>();
        for (int r:reserve){
            set_reserve.add(r);
        }
        for (int l:lost){
            set_lost.add(l);
        }
        HashSet<Integer> sub_reserve = new HashSet<>(set_reserve);
        HashSet<Integer> sub_lost = new HashSet<>(set_lost);
        sub_reserve.removeAll(set_lost); //도난을 당하면 못빌려줌
        sub_lost.removeAll(set_reserve); //여벌 체육복이 있으면 안빌려도 됨
        
        //체육복 빌릴 수 있는지 여부
        for (Integer i:sub_lost){
            if (sub_reserve.contains(i-1)) sub_reserve.remove(i-1);
            else if (sub_reserve.contains(i+1)) sub_reserve.remove(i+1);
            else n -= 1; //빌려줄 수 없으므로 체육 수업 제외
        }
        
        return n;
    }
}