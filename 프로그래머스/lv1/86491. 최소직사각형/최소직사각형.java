

class Solution {
    public int solution(int[][] sizes) {
        int length = 0;
        int height = 0;
        int maxl = 0;
        int maxr = 0;
        for(int[] i : sizes){
            length = Math.max(i[0],i[1]);
            height = Math.min(i[0],i[1]);
            if (maxl < length) maxl = length;
            if (maxr < height) maxr = height;
        }
        return maxl*maxr;
    }
}