import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> friendsIdx = new HashMap<>();
        int[] giftValue = new int[friends.length];
        int[] giftCnt = new int[friends.length];
        int[][] graph = new int[friends.length][friends.length];
        for(int i = 0; i < friends.length; i++){
            friendsIdx.put(friends[i],i);
        }
        
        StringTokenizer st;
        String giver, receiver;
        for(int i = 0; i < gifts.length; i++){
            st = new StringTokenizer(gifts[i]);
            giver = st.nextToken();
            receiver = st.nextToken();
            giftValue[friendsIdx.get(giver)]++;
            giftValue[friendsIdx.get(receiver)]--;
            graph[friendsIdx.get(giver)][friendsIdx.get(receiver)]++;
        }
        
        for(int i = 0; i < friends.length; i++){
            for(int j = i+1; j < friends.length; j++){
                if(i==j) continue;
                if(graph[i][j] > graph[j][i]){
                    giftCnt[i]++;
                } else if(graph[i][j] < graph[j][i]){
                    giftCnt[j]++;
                } else if(giftValue[i] > giftValue[j]){
                    giftCnt[i]++;
                } else if(giftValue[i] < giftValue[j]){
                    giftCnt[j]++;
                }
            }
        }
        
        for(int i = 0; i < friends.length; i++){
            answer = Math.max(giftCnt[i],answer);
        }
        
        return answer;
    }
}