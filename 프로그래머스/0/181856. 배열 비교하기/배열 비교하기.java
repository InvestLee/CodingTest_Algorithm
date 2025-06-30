class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return arr1.length > arr2.length ? 1 : -1;
        for(int i = arr1.length-2; i >= 0; i--) arr1[i] += arr1[i+1];
        for(int i = arr2.length-2; i >= 0; i--) arr2[i] += arr2[i+1];
        if(arr1[0] != arr2[0]) return arr1[0] > arr2[0] ? 1 : -1;
        return 0;
    }
}