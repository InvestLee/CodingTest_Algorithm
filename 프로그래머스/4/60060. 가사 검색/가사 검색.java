import java.util.*;


class Solution {
    public int[] solution(String[] words, String[] queries) {
        Trie fw = new Trie();
        Trie re = new Trie();
        for(String str : words){
            fw.insert(str);
            re.insert(reverse(str));
        }
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(queries[i].charAt(0) == '?') answer[i] = re.find(reverse(queries[i]),0);
            else answer[i] = fw.find(queries[i],0);
        }
        
        return answer;
    }
    
    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}

class Trie{
    HashMap<Integer, Integer> lenCnt = new HashMap<>();
    Trie[] child = new Trie[26];
    
    public void insert(String str){
        Trie node = this;
        int len = str.length();
        lenCnt.put(len, lenCnt.getOrDefault(len, 0)+1);
        for(char c : str.toCharArray()){
            int idx = c - 'a';
            if(node.child[idx] == null) node.child[idx] = new Trie();
            node = node.child[idx];
            node.lenCnt.put(len, node.lenCnt.getOrDefault(len, 0)+1);
        }
    }
    
    public int find(String str, int i){
        char c = str.charAt(i);
        if(c == '?') return lenCnt.getOrDefault(str.length(), 0);
        int idx = c - 'a';
        if(child[idx] == null) return 0;
        else return child[idx].find(str, i + 1);
    }
}