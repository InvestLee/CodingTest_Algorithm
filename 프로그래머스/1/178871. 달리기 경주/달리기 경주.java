import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerRank = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            playerRank.put(players[i],i);
        }
        
        String temp;
        for(String call : callings){
            temp = call;
            players[playerRank.get(call)] = players[playerRank.get(call)-1];
            players[playerRank.get(call)-1] = temp;
            playerRank.put(players[playerRank.get(call)],playerRank.get(call));
            playerRank.put(call,playerRank.get(call)-1);
        }
        
        return players;
    }
}