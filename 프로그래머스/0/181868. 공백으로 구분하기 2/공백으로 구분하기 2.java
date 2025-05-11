import java.util.ArrayList;

class Solution {
    public String[] solution(String my_string) {
        String[] arr = my_string.split(" ");
        ArrayList<String> temp = new ArrayList<>();
        for(String word : arr){
            if(word.length() != 0) temp.add(word);
        }
        String[] result = new String[temp.size()];
        for(int i = 0; i < temp.size(); i++) result[i] = temp.get(i);
        return result;
    }
}