class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) return n;
        int answer = 0;
        int min = 0;
        int max = 10000 * n;
        int time = 0;
        int workload = 0;
        while(min <= max){
            int mid = (min + max) / 2;
            int count = cal(mid, cores);
            if(count >= n){
                max = mid - 1;
                time = mid;
                workload = count;
            } else {
                min = mid + 1;
            }
        }
        
        workload -= n;
        for(int i = cores.length-1; i >= 0; i--){
            if(time%cores[i] == 0){
                if(workload == 0){
                    answer = i+1;
                    break;
                }
                workload--;
            }
        }
        return answer;
    }
    
    public static int cal(int mid, int[] cores){
        int result = cores.length;
        for(int i = 0; i < cores.length; i++){
            result += mid/cores[i];
        }
        return result;
    }
}