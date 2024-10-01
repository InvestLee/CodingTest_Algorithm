class Solution {
    public int solution(int n, long l, long r) {
        return (int)(getCount(n,r) - getCount(n,l-1));
    }
    
    public long getCount(int n, long idx){
        if(n == 0) return 1;
        
        long div = (long) Math.pow(5, n - 1);
        long cnt1 = (long) Math.pow(4, n - 1);
        long zone = idx / div;
        
        if((idx%div) == 0) zone--;
        if(zone == 2) return cnt1 * zone;
        else if(zone < 2) return cnt1 * zone + getCount(n-1, idx-(div*zone));
        else return cnt1 * (zone - 1) + getCount(n-1, idx-(div*zone));
    }
}