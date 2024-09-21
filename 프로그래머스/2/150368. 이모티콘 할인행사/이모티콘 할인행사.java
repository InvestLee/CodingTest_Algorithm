class Solution {
    
    public static int[] answer;
    public static int[][] user;
    public static int[] emoticon;
    public static int[] discount;
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        user = users;
        emoticon = emoticons;
        discount = new int[emoticon.length];
        
        backtracking(0);
        
        return answer;
    }
    
    public static void backtracking(int idx){
        if(idx == discount.length){
            cal();
            return;
        }
        for(int i = 10; i <= 40; i += 10){
            discount[idx] = i;
            backtracking(idx+1);
        }
    }
    
    public static void cal(){
        int totalEarn = 0;
        int totalJoin = 0;
        int earn;
        for(int i = 0; i < user.length; i++){
            earn = 0;
            for(int j = 0; j < discount.length; j++){
                if(user[i][0] <= discount[j]){
                    earn += emoticon[j] * (100-discount[j]) / 100;
                }
            }
            if(earn >= user[i][1]){
                totalJoin++;
            } else {
                totalEarn += earn;
            }
        }
        
        if(totalJoin > answer[0]){
            answer[0] = totalJoin;
            answer[1] = totalEarn;
        } else if(totalJoin == answer[0] && totalEarn > answer[1]){
            answer[1] = totalEarn;
        }
    }
}