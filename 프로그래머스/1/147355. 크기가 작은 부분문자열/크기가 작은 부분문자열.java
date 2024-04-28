import java.math.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        BigInteger tnum;
        BigInteger pnum = new BigInteger(p);
        for(int i = 0; i < t.length() - len + 1; i++){
            tnum = new BigInteger(t.substring(i,i+len));
            if(tnum.compareTo(pnum) <= 0) answer++;
        }
        return answer;
    }
}