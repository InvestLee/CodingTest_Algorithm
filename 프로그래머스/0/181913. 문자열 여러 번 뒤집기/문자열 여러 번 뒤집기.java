class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int i = 0; i < queries.length; i++){
            String front = sb.substring(0,queries[i][0]);
            String rev = new StringBuilder(sb.substring(queries[i][0],queries[i][1]+1)).reverse().toString();
            String back = sb.substring(queries[i][1]+1);
            sb = new StringBuilder(front+rev+back);
        }
        return sb.toString();
    }
}