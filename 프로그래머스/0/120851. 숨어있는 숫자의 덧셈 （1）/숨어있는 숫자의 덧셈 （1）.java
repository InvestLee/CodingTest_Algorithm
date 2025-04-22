class Solution {
    public int solution(String my_string) {
        String num = my_string.replaceAll("[^0-9]","");
        int answer = 0;
        for(int i = 0; i < num.length(); i++) answer += num.charAt(i) - '0';
        return answer;
    }
}