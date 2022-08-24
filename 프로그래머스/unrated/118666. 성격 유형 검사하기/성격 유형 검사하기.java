import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        //성격 유형 딕셔너리 화
        HashMap<String, Integer> hashSurvey = new HashMap<>();
        hashSurvey.put("RT",0);
        hashSurvey.put("CF",0);
        hashSurvey.put("JM",0);
        hashSurvey.put("AN",0);
        //성격유형점수 산정을 위한 연산
        for (int i = 0; i < choices.length; i++) choices[i] -= 4;
        //성격유형점수 연산
        for (int i = 0; i < survey.length; i++){
            if (hashSurvey.containsKey(survey[i])) hashSurvey.put(survey[i],hashSurvey.get(survey[i])+choices[i]);
            else{
                StringBuffer sb = new StringBuffer(survey[i]);
                String s_rev = sb.reverse().toString();
                hashSurvey.put(s_rev,hashSurvey.get(s_rev)-choices[i]);
            }
        }
        //성격유형 판별
        for (String ss : hashSurvey.keySet()){
            if (hashSurvey.get(ss) > 0) answer += ss.charAt(1);
            else answer += ss.charAt(0); 
        }
        return answer;
    }
}