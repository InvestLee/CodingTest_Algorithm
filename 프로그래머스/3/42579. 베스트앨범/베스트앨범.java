import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreCnt = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> musicCnt = new HashMap<>();
        for(int i = 0; i < plays.length; i++){
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i],0)+plays[i]);
            if(!musicCnt.containsKey(genres[i])){
                musicCnt.put(genres[i], new PriorityQueue<>((o1,o2)->{
                    if(o2[1]==o1[1]) return o1[0]-o2[0];
                    return o2[1]-o1[1];
                    }));
            }
            musicCnt.get(genres[i]).offer(new int[]{i, plays[i]});
        }
        ArrayList<String> genreArr = new ArrayList<>(genreCnt.keySet());
        Collections.sort(genreArr, (o1,o2)-> genreCnt.get(o2) - genreCnt.get(o1));
        for(String g : genreArr){
            for(int i = 0; i < 2; i++){
                if(!musicCnt.get(g).isEmpty()){
                    answer.add(musicCnt.get(g).poll()[0]);
                } else {
                    break;
                }
            }
        }
        return answer.stream().mapToInt(a->a).toArray();
    }
}