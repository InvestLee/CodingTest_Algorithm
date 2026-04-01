import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (o1, o2) -> {return o1[0]-o2[0];});
        return (dots[1][1]-dots[0][1])*(dots[2][0]-dots[0][0]);
    }
}