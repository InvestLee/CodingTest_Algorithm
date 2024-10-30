import java.util.*;

class Solution {
    public static int[] parents = new int[2501];
    public static String[] table = new String[2501];
    public static ArrayList<String> answer = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        for(int i = 1; i < 2501; i++){
            parents[i] = i;
        }
        
        int r, c, r1, c1, r2, c2, p;
        String value;
        for(String command : commands){
            String[] line = command.split(" ");
            if(line[0].equals("UPDATE")){
                if(line.length == 4){
                    r = Integer.parseInt(line[1]);
                    c = Integer.parseInt(line[2]);
                    table[find(getIndex(r,c))] = line[3];
                } 
                else {
                    for(int i = 1; i < 2501; i++){
                        if(line[1].equals(table[i])){
                            table[i] = line[2];
                        }
                    }
                }
            }
            else if(line[0].equals("MERGE")){
                r1 = Integer.parseInt(line[1]);
                c1 = Integer.parseInt(line[2]);
                r2 = Integer.parseInt(line[3]);
                c2 = Integer.parseInt(line[4]);
                union(getIndex(r1, c1), getIndex(r2, c2));
            }
            else if(line[0].equals("UNMERGE")){
                r = Integer.parseInt(line[1]);
                c = Integer.parseInt(line[2]);
                for(int i = 1; i < 2501; i++){
                    find(i);
                }
                p = parents[getIndex(r,c)];
                value = table[p];
                for(int i = 1; i < 2501; i++){
                    if(parents[i] == p){
                        parents[i] = i;
                        table[i] = null;
                    }
                }
                table[getIndex(r,c)] = value;
            }
            else{
                r = Integer.parseInt(line[1]);
                c = Integer.parseInt(line[2]);
                value = table[find(getIndex(r,c))];
                if(value == null){
                    answer.add("EMPTY");
                } 
                else {
                    answer.add(value);
                }
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    public static int getIndex(int r, int c){
        return 50 * (r-1) + c;
    }
    
    public static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(table[a] == null) table[a] = table[b]; 
            table[b] = null;
            parents[b] = a;
        }
    }
}