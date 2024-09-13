class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int big = Math.max(bill[0], bill[1]);
        int small = Math.min(bill[0], bill[1]);
        int walletLong = Math.max(wallet[0], wallet[1]);
        int walletShort = Math.min(wallet[0], wallet[1]);
        
        bill[0] = big;
        bill[1] = small;
        while(walletLong < bill[0] || walletShort < bill[1]){
            big = bill[0];
            small = bill[1];
            big /= 2;
            if(big > small){
                bill[0] = big;
                bill[1] = small;
            } else {
                bill[0] = small;
                bill[1] = big;
            }
            answer++;
        }
        return answer;
    }
}