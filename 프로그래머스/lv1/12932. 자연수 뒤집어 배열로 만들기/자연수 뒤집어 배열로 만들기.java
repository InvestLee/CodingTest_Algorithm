class Solution {
    public int[] solution(long n) {
        String ss = ""+n;
        StringBuilder sb = new StringBuilder(ss);
        sb.reverse();
        String[] temp_s = sb.toString().split("");
        int[] answer = new int[temp_s.length];
        for (int i = 0; i < temp_s.length; i++) answer[i] = Integer.parseInt(temp_s[i]);
        return answer;
    }
}