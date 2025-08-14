class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String temp = "";
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) - '0' <= 9) temp += my_string.charAt(i);
            else if(temp.length() > 0) {
                answer += Integer.parseInt(temp);
                temp = "";
            }
        } if(temp.length() > 0) answer += Integer.parseInt(temp);
        return answer;
    }
}