import java.util.*;

class Solution {
    public int solution(int[] nums) {
        boolean[] visited = new boolean[2998];
        System.out.print(visited[0]);
        for (int i = 2; i < Math.sqrt(2998)+1; i++){
            int j = 2;
            while (i*j < 2998){
                visited[i*j] = true;
                j++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < list.size(); i++){
            if (!visited[list.get(i)]) result++;
        }
        
        return result;
    }
}