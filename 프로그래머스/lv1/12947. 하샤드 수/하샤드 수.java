class Solution {
    public boolean solution(int x) {
        //int를 String으로 전환 후 자릿수 분할
        String[] x_str = String.valueOf(x).split(""); 
        int sum = 0;
        for (String s:x_str){
            sum += Integer.parseInt(s);
        }
        if (x%sum==0){
            return true;
        }
        return false;
    }
}