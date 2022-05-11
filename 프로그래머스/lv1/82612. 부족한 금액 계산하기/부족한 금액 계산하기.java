class Solution {
    public long solution(int price, int money, int count) {
        long Total = price;
        for (int i = 2;i<=count;i++) Total += price*i;
        long result = Total-money;
        if (Total < money) result = 0;
        return result;
    }
}