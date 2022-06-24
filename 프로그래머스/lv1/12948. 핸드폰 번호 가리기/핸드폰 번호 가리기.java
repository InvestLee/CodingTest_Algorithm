class Solution {
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray(); //String을 char배열로 변환
        for(int i = 0; i < ch.length - 4; i++){
            ch[i] = '*';
        }
        return String.valueOf(ch); //char배열을 스트링으로 변환
    }
}