class Solution {
    public int solution(String myString, String pat) {
        String temp = myString.replace("A","C").replace("B","A").replace("C","B").replace(pat, "");
        if(temp.length() != myString.length()) return 1;
        return 0;
    }
}