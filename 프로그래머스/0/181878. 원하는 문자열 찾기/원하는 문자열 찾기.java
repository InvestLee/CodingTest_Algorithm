class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        return myString.length() != myString.replace(pat,"").length() ? 1 : 0;
    }
}