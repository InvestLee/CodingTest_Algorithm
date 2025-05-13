class Solution {
    public int solution(int[] num_list) {
        String odd = "", even = "";
        for(int num : num_list){
            if(num % 2 == 1) odd += String.valueOf(num);
            else even += String.valueOf(num);
        }
        return Integer.parseInt(odd)+Integer.parseInt(even);
    }
}