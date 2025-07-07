class Solution {
    public int solution(String my_string, String is_suffix) {
        int idx = my_string.length()-is_suffix.length();
        return idx < 0 || !my_string.substring(idx).equals(is_suffix) ? 0 : 1;
    }
}