class Solution {
    public int solution(int[] num_list) {
        for(int i = num_list.length-3; i >= 0; i--) num_list[i] += num_list[i+2];
        return num_list[0] > num_list[1] ? num_list[0] : num_list[1];
    }
}