class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if(eq.equals("=") && n == m) return 1;
        if(ineq.equals(">")) return n > m ? 1 : 0;
        else return n < m ? 1 : 0;
    }
}