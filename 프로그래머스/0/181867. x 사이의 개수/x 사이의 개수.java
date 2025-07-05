class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        int num = myString.charAt(myString.length()-1) == 'x' ? 1 : 0;
        int[] answer = new int[arr.length + num];
        for(int i = 0; i < arr.length; i++) answer[i] += arr[i].length();
        return answer;
    }
}