import java.util.*;

class Solution {
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> answer = new ArrayList<>();
        int sel;
        
        if(ext.equals("code")) sel = 0;
        else if(ext.equals("date")) sel = 1;
        else if(ext.equals("maximum")) sel = 2;
        else sel = 3;
        
        for(int i = 0; i < data.length; i++){
            if(data[i][sel] < val_ext) answer.add(data[i]);
        }
        
        final int si;
        if(sort_by.equals("code")) si = 0;
        else if(sort_by.equals("date")) si = 1;
        else if(sort_by.equals("maximum")) si = 2;
        else si = 3;
        
        Collections.sort(answer,(o1,o2)->o1[si]-o2[si]);
        
        return answer;
    }
}