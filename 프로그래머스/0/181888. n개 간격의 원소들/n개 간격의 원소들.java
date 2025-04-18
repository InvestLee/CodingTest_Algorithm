class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length/n+(num_list.length%n>0?1:0)];
        for(int i = 0; i < num_list.length; i += n) answer[i/n] = num_list[i];
        return answer;
    }
}