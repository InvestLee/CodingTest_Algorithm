import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                if(!arr.contains(numbers[i]+numbers[j])) arr.add(numbers[i]+numbers[j]);
            }
        }
        arr.sort(Comparator.naturalOrder());
        Integer[] List = arr.toArray(new Integer[0]);
        int[] result = Arrays.stream(List).mapToInt(Integer::intValue).toArray();
        return result;
    }
}