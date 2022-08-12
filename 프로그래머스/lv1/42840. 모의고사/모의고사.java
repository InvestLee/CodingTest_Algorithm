import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int[] pattern1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Integer> supo1 = new ArrayList<Integer>();
        ArrayList<Integer> supo2 = new ArrayList<Integer>();
        ArrayList<Integer> supo3 = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++){
            supo1.add(pattern1[i%10]);
            supo2.add(pattern2[i%16]);
            supo3.add(pattern3[i%20]);
        }
        ArrayList<ArrayList<Integer>> supo = new ArrayList<ArrayList<Integer>>();
        supo.add(supo1);
        supo.add(supo2);
        supo.add(supo3);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < answers.length; j++){
                if (supo.get(i).get(j).equals(answers[j])){
                    answer[i] += 1;
                }
            }
        }
        int max_score = Arrays.stream(answer).max().getAsInt();
        int count = 0;
        ArrayList <Integer> result = new ArrayList<Integer> ();
        for (int i = 0; i < 3; i++){
            if (answer[i] == max_score){
                count += 1;
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}