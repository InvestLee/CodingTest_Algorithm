class Solution {
    public String solution(String my_string, int n) {
        return my_string.replaceAll(".", "$0".repeat(n));
    }
}