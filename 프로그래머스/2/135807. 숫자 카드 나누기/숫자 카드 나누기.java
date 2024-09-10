import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        if(check(arrayA, gcdB)){
            answer = Math.max(answer, gcdB);
        }
        if(check(arrayB, gcdA)){
            answer = Math.max(answer, gcdA);
        }
        
        return answer;
    }
    
    public static int gcd(int[] arr){
        return Arrays.stream(arr).reduce(arr[0], (a,b) -> gcd(a,b));
    }
    
    public static int gcd(int a, int b){
        if(a%b == 0) return b;
        return gcd(b, a%b);
    }
    
    public static boolean check(int[] arr, int num){
        for(int i : arr){
            if(i % num == 0) return false;
        }
        return true;
    }
}