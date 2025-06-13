class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
        if(str[1].equals("+")) return Integer.parseInt(str[0])+Integer.parseInt(str[2]);
        if(str[1].equals("-")) return Integer.parseInt(str[0])-Integer.parseInt(str[2]);
        return Integer.parseInt(str[0])*Integer.parseInt(str[2]);
    }
}