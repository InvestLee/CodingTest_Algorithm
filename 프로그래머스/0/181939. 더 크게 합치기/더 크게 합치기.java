class Solution {
    public int solution(int a, int b) {
        return Integer.parseInt(String.valueOf(a)+String.valueOf(b))>Integer.parseInt(String.valueOf(b)+String.valueOf(a))?Integer.parseInt(String.valueOf(a)+String.valueOf(b)):Integer.parseInt(String.valueOf(b)+String.valueOf(a));
    }
}