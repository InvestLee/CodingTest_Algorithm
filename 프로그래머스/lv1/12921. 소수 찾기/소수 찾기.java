import java.util.*;

class Solution {
    public int solution(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,false);
        int answer = 0;
        for (int i = 2; i <= n; i++){
            if (arr[i] == false){
                int j = 2;
                answer+=1;
                while(i*j <= n){
                    arr[i*j] = true;
                    j++;
                }
            }    
            
        }
        return answer;
    }
}