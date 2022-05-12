import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int choice = (nums.length)/2;
        ArrayList<Integer> number = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (!number.contains(nums[i])) number.add(nums[i]);
        }
        int result = 0;
        if (number.size()<choice) result=number.size();
        else result = choice;
        return result;
    }
}