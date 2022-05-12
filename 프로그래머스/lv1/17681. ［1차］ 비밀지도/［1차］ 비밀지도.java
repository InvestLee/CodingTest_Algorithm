class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] bi_arr1 = new String[n];
        String[] bi_arr2 = new String[n];
        String[] result = new String[n];
        for (int i = 0; i < n; i++){
            bi_arr1[i] = Integer.toBinaryString(arr1[i]);
            while (bi_arr1[i].length() != n) bi_arr1[i] = "0"+bi_arr1[i];
            bi_arr2[i] = Integer.toBinaryString(arr2[i]);
            while (bi_arr2[i].length() != n) bi_arr2[i] = "0"+bi_arr2[i];
        }
        for (int i = 0; i < n; i++){
            result[i] = "";
            for (int j = 0; j < n; j++){
                if(bi_arr1[i].substring(j,j+1).equals("1") || bi_arr2[i].substring(j,j+1).equals("1")){
                    result[i] += "#";  
                } 
                else result[i] += " ";
            }
        }
        return result;
    }
}