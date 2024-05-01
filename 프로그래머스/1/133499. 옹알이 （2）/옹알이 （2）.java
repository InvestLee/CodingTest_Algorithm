class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            babbling[i] = babbling[i].replaceAll("aya","1");
            babbling[i] = babbling[i].replaceAll("ye","2");
            babbling[i] = babbling[i].replaceAll("woo","3");
            babbling[i] = babbling[i].replaceAll("ma","4");
        }
        
        char temp1, temp2;
        boolean flag;
        for(int i = 0; i < babbling.length; i++){
            flag = true;
            if(babbling[i].length() == 1){
                if(babbling[i].charAt(0) - '0' > 4) flag = false;
            }else{
                for(int j = 1; j < babbling[i].length(); j++){
                    temp1 = babbling[i].charAt(j-1);
                    temp2 = babbling[i].charAt(j);
                    if(temp1 - '0' > 4 || temp2 - '0' > 4 || temp1 == temp2){
                        flag = false;
                    }
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}