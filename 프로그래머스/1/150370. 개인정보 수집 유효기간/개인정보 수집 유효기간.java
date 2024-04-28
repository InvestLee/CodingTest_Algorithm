import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] temp;
        for(int i = 0; i < terms.length; i++){
            temp = terms[i].split(" ");
            hashMap.put(temp[0], Integer.parseInt(temp[1])*28); 
        }
        
        String[] dateTemp;
        int dateCnt;
        String[] todayTemp = today.split("\\.");
        int todayCnt = (Integer.parseInt(todayTemp[0]))*12*28
                    +(Integer.parseInt(todayTemp[1]))*28
                    +(Integer.parseInt(todayTemp[2]));
        for(int i = 0; i < privacies.length; i++){
            temp = privacies[i].split(" ");
            dateTemp = temp[0].split("\\.");
            dateCnt = (Integer.parseInt(dateTemp[0]))*12*28
                +(Integer.parseInt(dateTemp[1]))*28
                +(Integer.parseInt(dateTemp[2]));
            if(dateCnt+hashMap.get(temp[1]) <= todayCnt) result.add(i+1);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}