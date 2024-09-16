import java.util.*;

class Solution {
    
    public static ArrayList<Double> arr;
    public static double[] sum;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        arr = new ArrayList<>();
        double doubleK;
        while(k != 1){
            doubleK = k;
            arr.add(doubleK);
            if(k % 2 == 0){
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }
        arr.add(1.0);
        
        int len = arr.size();
        sum = new double[len];
        for(int i = 1; i < len; i++){
            sum[i] = (arr.get(i-1)+arr.get(i)) / 2;
        }
        
        for(int i = 1; i < len; i++){
            sum[i] += sum[i-1];
        }
        
        double value;
        for(int i = 0; i < ranges.length; i++){
            if(ranges[i][0] > len+ranges[i][1]-1){
                answer[i] = -1.0;
            } else {
                answer[i] = sum[len+ranges[i][1]-1] 
                    - sum[ranges[i][0]];
            }
        }
        
        return answer;
    }
}