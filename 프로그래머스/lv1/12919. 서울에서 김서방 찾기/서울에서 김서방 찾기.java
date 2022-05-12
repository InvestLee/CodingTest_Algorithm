import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        int location = Arrays.asList(seoul).indexOf("Kim");
        String answer = "김서방은 "+location+"에 있다";
        return answer;
    }
}