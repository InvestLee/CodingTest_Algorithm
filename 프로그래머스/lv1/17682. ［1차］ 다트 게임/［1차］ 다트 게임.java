import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int count = 0;
        int [] cal = {0,0,0};
        String temp = "";
        for(int i = 0; i<dartResult.length(); i++){
            if (Character.isDigit(dartResult.charAt(i))) temp += dartResult.charAt(i);
            else{
                if (temp.length() != 0){
                    cal[count] = Integer.parseInt(temp);
                    count++;
                }
                temp = "";
                if (dartResult.charAt(i) == 'S') continue;
                else if (dartResult.charAt(i) == 'D') cal[count-1] = (int)Math.pow(cal[count-1],2);
                else if (dartResult.charAt(i) == 'T') cal[count-1] = (int)Math.pow(cal[count-1],3);
                else if (dartResult.charAt(i) == '#') cal[count-1] *= -1;
                else{
                    if (count == 1) cal[count-1] *= 2;
                    else{
                        cal[count-1] *= 2;
                        cal[count-2] *= 2;
                    }
                }
            }
        }
        return Arrays.stream(cal).sum();
    }
}