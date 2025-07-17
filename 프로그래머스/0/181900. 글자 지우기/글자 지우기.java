class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        boolean[] delIdx = new boolean[my_string.length()];
        for(int i = 0; i < indices.length; i++) delIdx[indices[i]] = true;
        for(int i = 0; i < my_string.length(); i++) if(!delIdx[i]) answer += my_string.charAt(i);
        return answer;
    }
}